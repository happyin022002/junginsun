/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSearchAuthorityOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.29 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSearchAuthorityOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSearchAuthorityOfficeRSQL(){
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSearchAuthorityOfficeRSQL").append("\n"); 
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
		query.append("SELECT  C.JO_CRR_CD" ).append("\n"); 
		query.append(",       C.TRD_CD" ).append("\n"); 
		query.append(",       C.RLANE_CD" ).append("\n"); 
		query.append(",       C.VNDR_SEQ" ).append("\n"); 
		query.append(",       CUST_CNT_CD||CUST_SEQ CRM_ROW_ID" ).append("\n"); 
		query.append(",       V.VNDR_LGL_ENG_NM||'/'|| (SELECT  S1.CUST_LGL_ENG_NM FROM MDM_CUSTOMER S1 WHERE S1.CUST_CNT_CD=C.CUST_CNT_CD AND S1.CUST_SEQ=C.CUST_SEQ)VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",       A.AUTH_OFC_CD" ).append("\n"); 
		query.append(",       A.JO_CRR_AUTH_CD" ).append("\n"); 
		query.append(",       CASE WHEN  A.DELT_FLG ='Y' THEN 'Y' ELSE 'N' END DELT_FLG" ).append("\n"); 
		query.append("FROM  JOO_CARRIER  C" ).append("\n"); 
		query.append(",       MDM_VENDOR   V" ).append("\n"); 
		query.append(",       JOO_CRR_AUTH A" ).append("\n"); 
		query.append("WHERE   C.JO_CRR_CD = A.JO_CRR_CD(+)" ).append("\n"); 
		query.append("AND    C.RLANE_CD  = A.RLANE_CD (+)" ).append("\n"); 
		query.append("AND    C.VNDR_SEQ  = V.VNDR_SEQ (+)" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND    C.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND    C.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND    C.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    A.AUTH_OFC_CD   = @[auth_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'A')" ).append("\n"); 
		query.append("#if (${delt_flg} == 'N')" ).append("\n"); 
		query.append("AND     A.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} == 'Y')" ).append("\n"); 
		query.append("AND     A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY C.JO_CRR_CD, C.TRD_CD, C.RLANE_CD, V.VNDR_LOCL_LANG_NM, A.AUTH_OFC_CD" ).append("\n"); 

	}
}