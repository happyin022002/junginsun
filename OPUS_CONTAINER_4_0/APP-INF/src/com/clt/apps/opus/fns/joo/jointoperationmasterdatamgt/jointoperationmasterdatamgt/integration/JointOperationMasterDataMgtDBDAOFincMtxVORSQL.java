/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOFincMtxVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOFincMtxVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_FINC_MTX 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOFincMtxVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOFincMtxVORSQL").append("\n"); 
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
		query.append("       B.JO_CRR_CD," ).append("\n"); 
		query.append("       B.RLANE_CD," ).append("\n"); 
		query.append("       B.RE_DIVR_CD,      " ).append("\n"); 
		query.append("       B.JO_STL_ITM_CD," ).append("\n"); 
		query.append("#if (${re_divr_cd} == 'R') " ).append("\n"); 
		query.append("       A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_SEQ," ).append("\n"); 
		query.append("#elseif (${re_divr_cd} == 'E') " ).append("\n"); 
		query.append("       ''||A.VNDR_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       C.DR_ACCT_CD," ).append("\n"); 
		query.append("       B.DR_CTR_CD," ).append("\n"); 
		query.append("       B.DR_LOC_CD," ).append("\n"); 
		query.append("       C.CR_ACCT_CD," ).append("\n"); 
		query.append("       B.CR_CTR_CD," ).append("\n"); 
		query.append("       B.CR_LOC_CD," ).append("\n"); 
		query.append("       D.JO_STL_ITM_NM," ).append("\n"); 
		query.append("       B.LOCL_CURR_CD," ).append("\n"); 
		query.append("       B.UPD_USR_ID AS USR_ID" ).append("\n"); 
		query.append("FROM   JOO_CARRIER      A," ).append("\n"); 
		query.append("       JOO_FINC_MTX     B," ).append("\n"); 
		query.append("       JOO_STL_ITM_ACCT C," ).append("\n"); 
		query.append("       JOO_STL_ITM      D" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD     = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD    = C.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    B.JO_STL_ITM_CD = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    C.JO_STL_ITM_CD = D.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    B.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    B.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("ORDER BY D.ORD_SEQ" ).append("\n"); 

	}
}