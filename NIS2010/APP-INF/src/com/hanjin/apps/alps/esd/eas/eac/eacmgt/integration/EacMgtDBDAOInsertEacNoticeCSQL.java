/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertEacNoticeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOInsertEacNoticeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Rejection Notice History  를 저장합니다.
	  * </pre>
	  */
	public EacMgtDBDAOInsertEacNoticeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertEacNoticeCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_RJCT_HIS(EAC_NO" ).append("\n"); 
		query.append("                                   , NTC_HIS_SEQ" ).append("\n"); 
		query.append("                                   , VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("                                   , EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                                   , EML_CTNT" ).append("\n"); 
		query.append("                                   , EAC_RJCT_RSN" ).append("\n"); 
		query.append("                                   , NTC_SND_DT" ).append("\n"); 
		query.append("                                   , RCVR_EML" ).append("\n"); 
		query.append("                                   , RCVR_PHN_NO" ).append("\n"); 
		query.append("                                   , RCVR_FAX_NO" ).append("\n"); 
		query.append("                                   , EAC_EML_USE_FLG" ).append("\n"); 
		query.append("                                   , EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("                                   , EML_SND_NO" ).append("\n"); 
		query.append("                                   , FAX_SND_NO" ).append("\n"); 
		query.append("                                   , VNDR_SEQ" ).append("\n"); 
		query.append("                                   , N3PTY_SRC_NO" ).append("\n"); 
		query.append("                                   , N3PTY_SRC_DT" ).append("\n"); 
		query.append("                                   , CURR_CD" ).append("\n"); 
		query.append("                                   , INV_AMT" ).append("\n"); 
		query.append("                                   , INV_CNG_AMT" ).append("\n"); 
		query.append("                                   , INV_AUD_AMT" ).append("\n"); 
		query.append("                                   , INV_AUD_USD_AMT" ).append("\n"); 
		query.append("                                   , WO_NO_CTNT" ).append("\n"); 
		query.append("                                   , VVD_CD_CTNT" ).append("\n"); 
		query.append("                                   , BL_NO" ).append("\n"); 
		query.append("                                   , EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("                                   , CRE_USR_ID" ).append("\n"); 
		query.append("                                   , CRE_DT" ).append("\n"); 
		query.append("                                   , UPD_USR_ID" ).append("\n"); 
		query.append("                                   , UPD_DT" ).append("\n"); 
		query.append("                                   , CRE_OFC_CD" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                   SELECT A.EAC_NO" ).append("\n"); 
		query.append("                                        , (SELECT COUNT(1)+1 FROM EAS_EXPN_AUD_CS_RJCT_HIS WHERE EAC_NO = A.EAC_NO)" ).append("\n"); 
		query.append("                                        , A.VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("                                        , A.EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                                        , A.EML_CTNT" ).append("\n"); 
		query.append("                                        , A.EAC_RJCT_RSN" ).append("\n"); 
		query.append("                                        , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[eac_ofc_cd])" ).append("\n"); 
		query.append("                                        , @[rcvr_eml]" ).append("\n"); 
		query.append("                                        , @[rcvr_phn_no]" ).append("\n"); 
		query.append("                                        , @[rcvr_fax_no]" ).append("\n"); 
		query.append("                                        , B.EAC_EML_USE_FLG" ).append("\n"); 
		query.append("                                        , B.EAC_FAX_USE_FLG     " ).append("\n"); 
		query.append("                                        , @[eml_snd_no]" ).append("\n"); 
		query.append("                                        , @[fax_snd_no]" ).append("\n"); 
		query.append("                                        , B.VNDR_SEQ" ).append("\n"); 
		query.append("                                        , A.N3PTY_SRC_NO" ).append("\n"); 
		query.append("                                        , A.N3PTY_SRC_DT" ).append("\n"); 
		query.append("                                        , A.CURR_CD" ).append("\n"); 
		query.append("                                        , A.INV_AMT" ).append("\n"); 
		query.append("                                        , A.INV_CNG_AMT" ).append("\n"); 
		query.append("                                        , A.INV_AUD_AMT" ).append("\n"); 
		query.append("                                        , A.INV_AUD_USD_AMT     " ).append("\n"); 
		query.append("                                        , A.WO_NO_CTNT" ).append("\n"); 
		query.append("                                        , A.VVD_CD_CTNT     " ).append("\n"); 
		query.append("                                        , C.BL_NO" ).append("\n"); 
		query.append("                                        , A.EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("                                        , @[cre_usr_id]" ).append("\n"); 
		query.append("                                        , SYSDATE" ).append("\n"); 
		query.append("                                        , @[cre_usr_id]" ).append("\n"); 
		query.append("                                        , SYSDATE" ).append("\n"); 
		query.append("                                        , @[eac_ofc_cd]" ).append("\n"); 
		query.append("                                   FROM   EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("                                        , EAS_EXPN_AUD_CS_CNTC_PNT B" ).append("\n"); 
		query.append("                                        , EAS_EXPN_AUD_CS_N3RD_PTY C" ).append("\n"); 
		query.append("                                   WHERE  A.EAC_NO = @[eac_no]" ).append("\n"); 
		query.append("                                   AND    A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("                                   AND    A.VNDR_CNTC_PNT_SEQ = B.VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("                                   AND    A.EAC_NO = C.EAC_NO(+)" ).append("\n"); 

	}
}