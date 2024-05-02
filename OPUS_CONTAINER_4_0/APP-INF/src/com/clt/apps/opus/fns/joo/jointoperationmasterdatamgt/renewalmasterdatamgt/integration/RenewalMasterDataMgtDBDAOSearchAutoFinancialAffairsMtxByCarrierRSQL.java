/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAOSearchAutoFinancialAffairsMtxByCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
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

public class RenewalMasterDataMgtDBDAOSearchAutoFinancialAffairsMtxByCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Financial Affairs Matrix by Carrier
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAOSearchAutoFinancialAffairsMtxByCarrierRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAOSearchAutoFinancialAffairsMtxByCarrierRSQL").append("\n"); 
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
		query.append("     , C.RE_DIVR_CD" ).append("\n"); 
		query.append("     , B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , C.DR_ACCT_CD" ).append("\n"); 
		query.append("     , E.AP_CTR_CD      AS DR_CTR_CD" ).append("\n"); 
		query.append("     , E.LOC_CD         AS DR_LOC_CD" ).append("\n"); 
		query.append("     , C.CR_ACCT_CD" ).append("\n"); 
		query.append("     , E.AP_CTR_CD      AS CR_CTR_CD" ).append("\n"); 
		query.append("     , E.LOC_CD         AS CR_LOC_CD" ).append("\n"); 
		query.append("     , NVL(@[locl_curr_cd], 'USD') AS LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM JOO_CARRIER A" ).append("\n"); 
		query.append("     , JOO_STL_ITM B" ).append("\n"); 
		query.append("     , JOO_STL_ITM_ACCT C" ).append("\n"); 
		query.append("     , (SELECT D.OFC_CD" ).append("\n"); 
		query.append("             , D.LOC_CD" ).append("\n"); 
		query.append("             , D.AP_CTR_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION D" ).append("\n"); 
		query.append("             , MDM_ORGANIZATION E" ).append("\n"); 
		query.append("         WHERE D.OFC_CD = E.AP_OFC_CD" ).append("\n"); 
		query.append("           AND E.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND ROWNUM   = 1) E" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD      = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("   AND B.JO_STL_ITM_CD  = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '') " ).append("\n"); 
		query.append("   AND C.RE_DIVR_CD     = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY C.RE_DIVR_CD, B.ORD_SEQ" ).append("\n"); 

	}
}