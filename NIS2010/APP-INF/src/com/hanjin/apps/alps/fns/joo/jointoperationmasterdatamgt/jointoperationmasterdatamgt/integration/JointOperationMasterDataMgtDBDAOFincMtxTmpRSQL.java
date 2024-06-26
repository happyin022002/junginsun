/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOFincMtxTmpRSQL.java
*@FileTitle : Adjustment Over Used Slot Hire for RDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.16 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOFincMtxTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * matrix를 생성하기위한 query
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOFincMtxTmpRSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOFincMtxTmpRSQL").append("\n"); 
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
		query.append("'R' AS IBFLAG," ).append("\n"); 
		query.append("B.JO_CRR_CD," ).append("\n"); 
		query.append("B.RLANE_CD," ).append("\n"); 
		query.append("B.RE_DIVR_CD," ).append("\n"); 
		query.append("B.JO_STL_ITM_CD," ).append("\n"); 
		query.append("#if (${re_divr_cd} == 'R')" ).append("\n"); 
		query.append("A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_SEQ," ).append("\n"); 
		query.append("#elseif (${re_divr_cd} == 'E')" ).append("\n"); 
		query.append("''||A.VNDR_SEQ AS CUST_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("C.DR_ACCT_CD," ).append("\n"); 
		query.append("B.DR_CTR_CD," ).append("\n"); 
		query.append("B.DR_LOC_CD," ).append("\n"); 
		query.append("C.CR_ACCT_CD," ).append("\n"); 
		query.append("B.CR_CTR_CD," ).append("\n"); 
		query.append("B.CR_LOC_CD," ).append("\n"); 
		query.append("B.LOCL_CURR_CD," ).append("\n"); 
		query.append("D.JO_STL_ITM_NM" ).append("\n"); 
		query.append("FROM   JOO_CARRIER      A," ).append("\n"); 
		query.append("JOO_FINC_MTX     B," ).append("\n"); 
		query.append("JOO_STL_ITM_ACCT C," ).append("\n"); 
		query.append("JOO_STL_ITM      D" ).append("\n"); 
		query.append("WHERE  A.JO_CRR_CD     = B.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD    = C.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    B.JO_STL_ITM_CD = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    C.JO_STL_ITM_CD = D.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    B.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    B.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'I' AS IBFLAG," ).append("\n"); 
		query.append("@[jo_crr_cd]  AS JO_CRR_CD," ).append("\n"); 
		query.append("@[rlane_cd]   AS RLANE_CD," ).append("\n"); 
		query.append("@[re_divr_cd] AS RE_DIVR_CD," ).append("\n"); 
		query.append("A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("#if (${re_divr_cd} == 'R')" ).append("\n"); 
		query.append("@[cust_cnt_cd]||LPAD(@[cust_seq],6,'0') AS CUST_SEQ," ).append("\n"); 
		query.append("#elseif (${re_divr_cd} == 'E')" ).append("\n"); 
		query.append("@[vndr_seq] AS CUST_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("B.DR_ACCT_CD," ).append("\n"); 
		query.append("C.AP_CTR_CD AS DR_CTR_CD," ).append("\n"); 
		query.append("C.LOC_CD    AS DR_LOC_CD," ).append("\n"); 
		query.append("B.CR_ACCT_CD," ).append("\n"); 
		query.append("C.AP_CTR_CD AS CR_CTR_CD," ).append("\n"); 
		query.append("C.LOC_CD    AS CR_LOC_CD," ).append("\n"); 
		query.append("'' AS LOCL_CURR_CD," ).append("\n"); 
		query.append("A.JO_STL_ITM_NM" ).append("\n"); 
		query.append("FROM   JOO_STL_ITM      A," ).append("\n"); 
		query.append("JOO_STL_ITM_ACCT B," ).append("\n"); 
		query.append("MDM_ORGANIZATION C," ).append("\n"); 
		query.append("MDM_ORGANIZATION D" ).append("\n"); 
		query.append("WHERE  A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    C.OFC_CD        = D.AP_OFC_CD" ).append("\n"); 
		query.append("AND    D.OFC_CD     = @[ofc_cd]" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD NOT IN (" ).append("\n"); 
		query.append("SELECT JO_STL_ITM_CD" ).append("\n"); 
		query.append("FROM   JOO_FINC_MTX X" ).append("\n"); 
		query.append("WHERE  X.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    X.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("AND    X.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER  BY 1 DESC" ).append("\n"); 

	}
}