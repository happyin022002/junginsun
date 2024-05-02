/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAOSearchCarrierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
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

public class RenewalMasterDataMgtDBDAOSearchCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Renewal Carrier 조회.
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAOSearchCarrierListRSQL(){
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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAOSearchCarrierListRSQL").append("\n"); 
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
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("         WHERE MV.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("           AND MV.VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD||A.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append("     , (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("         WHERE MC.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND MC.CUST_SEQ = A.CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.JO_STL_OPT_CD" ).append("\n"); 
		query.append("     , A.DELT_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN COUNT(*) > 0 THEN 'O'" ).append("\n"); 
		query.append("                    ELSE 'X'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("         WHERE CA.JO_CRR_CD = A.JO_CRR_CD" ).append("\n"); 
		query.append("           AND CA.RLANE_CD = A.RLANE_CD ) AS EXIST_AUTH_FLG" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN COUNT(*) > 0 THEN 'O'" ).append("\n"); 
		query.append("                    ELSE 'X'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM JOO_FINC_MTX CA" ).append("\n"); 
		query.append("         WHERE CA.JO_CRR_CD = A.JO_CRR_CD" ).append("\n"); 
		query.append("           AND CA.RLANE_CD = A.RLANE_CD ) AS EXIST_FINC_MTX_FLG" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN COUNT(*) > 0 THEN 'O'" ).append("\n"); 
		query.append("                    ELSE 'X'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM JOO_FINC_MTX CA" ).append("\n"); 
		query.append("             , JOO_STL_VVD SV" ).append("\n"); 
		query.append("         WHERE CA.JO_CRR_CD = A.JO_CRR_CD" ).append("\n"); 
		query.append("           AND CA.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("           AND CA.JO_CRR_CD = SV.JO_CRR_CD" ).append("\n"); 
		query.append("           AND CA.RLANE_CD = SV.RLANE_CD" ).append("\n"); 
		query.append("           AND CA.RE_DIVR_CD = SV.RE_DIVR_CD ) AS EXIST_CHILD_FLG" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN COUNT(*) > 0 THEN 'O'" ).append("\n"); 
		query.append("                    ELSE 'X'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM JOO_STL_BSS_PORT BP" ).append("\n"); 
		query.append("         WHERE BP.JO_CRR_CD = A.JO_CRR_CD" ).append("\n"); 
		query.append("           AND BP.RLANE_CD = A.RLANE_CD ) AS EXIST_STL_BSS_PORT_FLG" ).append("\n"); 
		query.append("     , NVL((SELECT LOCL_CURR_CD" ).append("\n"); 
		query.append("              FROM JOO_FINC_MTX CA" ).append("\n"); 
		query.append("             WHERE CA.JO_CRR_CD = A.JO_CRR_CD" ).append("\n"); 
		query.append("               AND CA.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("          ),'USD') AS LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM JOO_CARRIER A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("   AND A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${auth_ofc_cd}!='')" ).append("\n"); 
		query.append("   /* Condition Auth Office Cd */" ).append("\n"); 
		query.append("   AND EXISTS   (   SELECT 'X'" ).append("\n"); 
		query.append("                      FROM JOO_CRR_AUTH CA" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND CA.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                       AND CA.JO_CRR_CD        = A.JO_CRR_CD" ).append("\n"); 
		query.append("                       AND CA.RLANE_CD         = A.RLANE_CD" ).append("\n"); 
		query.append("                       AND CA.AUTH_OFC_CD      = @[auth_ofc_cd]" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("   AND A.DELT_FLG   = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.JO_CRR_CD, A.TRD_CD, A.RLANE_CD, A.VNDR_SEQ" ).append("\n"); 

	}
}