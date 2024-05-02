/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.06.24 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPlaceOfIssueAssociationList
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_ofc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_esig_asgn_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL").append("\n"); 
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
		query.append("SELECT A.BL_ESIG_ASGN_SEQ" ).append("\n"); 
		query.append("    ,(SELECT MC.SCONTI_CD FROM MDM_COUNTRY MC WHERE MC.CNT_CD = A.CNT_CD) AS REGION_NM" ).append("\n"); 
		query.append("	, A.CNT_CD" ).append("\n"); 
		query.append("    , A.BL_ISS_OFC_NM" ).append("\n"); 
		query.append("    , A.BL_ISS_OFC_CD" ).append("\n"); 
		query.append("	, B.ESIG_LST_NM || ',' || ESIG_N1ST_NM AS ISS_OFC_EMP_NM" ).append("\n"); 
		query.append("    , A.AGN_CO_NM1" ).append("\n"); 
		query.append("    , A.AGN_CO_NM2" ).append("\n"); 
		query.append("    , A.AGN_CO_NM3" ).append("\n"); 
		query.append("    , A.BL_ESIG_SEQ" ).append("\n"); 
		query.append("    , A.BL_ESIG_RMK    " ).append("\n"); 
		query.append("    , A.BL_ESIG_FLG" ).append("\n"); 
		query.append("    , A.BL_CPY_ESIG_FLG" ).append("\n"); 
		query.append("    , A.BL_KNT_FLG" ).append("\n"); 
		query.append("FROM BKG_BL_ESIG_OFC_ASGN A" ).append("\n"); 
		query.append("    ,BKG_BL_ESIG B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.BL_ESIG_SEQ = B.BL_ESIG_SEQ(+)" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("	AND A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_iss_ofc_nm} != '')" ).append("\n"); 
		query.append("	AND UPPER(A.BL_ISS_OFC_NM) LIKE '%' || UPPER(@[bl_iss_ofc_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_esig_asgn_seq} != '')" ).append("\n"); 
		query.append("	AND A.BL_ESIG_ASGN_SEQ = @[bl_esig_asgn_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_iss_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND A.BL_ISS_OFC_CD = @[bl_iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}