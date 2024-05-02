/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Financial Affairs Matrix Search
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxListRSQL(){
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
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAOSearchFinancialAffairsMtxListRSQL").append("\n"); 
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
		query.append("SELECT A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_NM" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , A.CUST_CD" ).append("\n"); 
		query.append("     , (SELECT MC.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER MC " ).append("\n"); 
		query.append("         WHERE MC.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("           AND MC.CUST_CNT_CD   = A.CUST_CNT_CD " ).append("\n"); 
		query.append("           AND MC.CUST_SEQ      = A.CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.VNDR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("           AND MV.VNDR_SEQ      = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.DR_ACCT_CD" ).append("\n"); 
		query.append("     , (SELECT MA.ACCT_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD  = A.DR_ACCT_CD) AS DR_ACCT_NM" ).append("\n"); 
		query.append("     , A.DR_CTR_CD" ).append("\n"); 
		query.append("     , A.DR_LOC_CD" ).append("\n"); 
		query.append("     , A.CR_ACCT_CD" ).append("\n"); 
		query.append("     , (SELECT MA.ACCT_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_ACCOUNT MA" ).append("\n"); 
		query.append("         WHERE MA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND MA.ACCT_CD  = A.CR_ACCT_CD) AS CR_ACCT_NM" ).append("\n"); 
		query.append("     , A.CR_CTR_CD" ).append("\n"); 
		query.append("     , A.CR_LOC_CD" ).append("\n"); 
		query.append("     , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("     , A.CRE_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , A.UPD_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.JO_CRR_CD" ).append("\n"); 
		query.append("             , B.RLANE_CD" ).append("\n"); 
		query.append("             , B.RE_DIVR_CD" ).append("\n"); 
		query.append("             , B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , D.JO_STL_ITM_NM" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD" ).append("\n"); 
		query.append("             , A.CUST_SEQ" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("             , A.VNDR_SEQ AS VNDR_SEQ" ).append("\n"); 
		query.append("             , C.DR_ACCT_CD" ).append("\n"); 
		query.append("             , B.DR_CTR_CD" ).append("\n"); 
		query.append("             , B.DR_LOC_CD" ).append("\n"); 
		query.append("             , C.CR_ACCT_CD" ).append("\n"); 
		query.append("             , B.CR_CTR_CD" ).append("\n"); 
		query.append("             , B.CR_LOC_CD" ).append("\n"); 
		query.append("             , B.LOCL_CURR_CD" ).append("\n"); 
		query.append("             , TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("             , A.CRE_USR_ID" ).append("\n"); 
		query.append("             , TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("             , A.UPD_USR_ID" ).append("\n"); 
		query.append("             , D.ORD_SEQ" ).append("\n"); 
		query.append("          FROM JOO_CARRIER A" ).append("\n"); 
		query.append("             , JOO_FINC_MTX B" ).append("\n"); 
		query.append("             , JOO_STL_ITM_ACCT C" ).append("\n"); 
		query.append("             , JOO_STL_ITM D" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("           AND A.JO_CRR_CD      = B.JO_CRR_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD       = B.RLANE_CD   " ).append("\n"); 
		query.append("           AND B.RE_DIVR_CD     = C.RE_DIVR_CD" ).append("\n"); 
		query.append("           AND B.JO_STL_ITM_CD  = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("           AND C.JO_STL_ITM_CD  = D.JO_STL_ITM_CD" ).append("\n"); 
		query.append("           AND B.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("           AND B.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("        #if (${re_divr_cd} != '')    " ).append("\n"); 
		query.append("           AND B.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        #if (${jo_stl_itm_cd} != '')    " ).append("\n"); 
		query.append("           AND B.JO_STL_ITM_CD     = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append(" ORDER BY A.ORD_SEQ" ).append("\n"); 

	}
}