/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RateMgtDBDAOsearchAgreementComboListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAgreementComboListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAgreementComboListData
	  * </pre>
	  */
	public RateMgtDBDAOsearchAgreementComboListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAgreementComboListDataRSQL").append("\n"); 
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
		query.append("SELECT   D.TRSM_MOD_CD" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("       , A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("       , A.AGMT_SEQ" ).append("\n"); 
		query.append("       , A.AGMT_VER_NO" ).append("\n"); 
		query.append("       , A.EQ_KND_CD" ).append("\n"); 
		query.append("       , A.AGMT_LST_VER_FLG" ).append("\n"); 
		query.append("       , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("       , B.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("       , A.PAY_TERM_DYS" ).append("\n"); 
		query.append("       , A.AGMT_REF_NO" ).append("\n"); 
		query.append("       , TO_CHAR(A.AGMT_DT, 'YYYY-MM-DD') AS AGMT_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("       , TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("       , A.CURR_CD" ).append("\n"); 
		query.append("       , A.DELT_FLG" ).append("\n"); 
		query.append("       , A.AGMT_RMK" ).append("\n"); 
		query.append("       , A.AGMT_OFC_CD" ).append("\n"); 
		query.append("       , A.TRF_NO" ).append("\n"); 
		query.append("       , A.CRE_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("       , D.EDI_ID" ).append("\n"); 
		query.append("       , E.MNR_CD_DP_DESC AS EQ_TYPE_NAME" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("           SELECT   GD.MNR_CD_DP_DESC" ).append("\n"); 
		query.append("           FROM     MNR_RPR_TRF_HDR TH,MNR_GEN_CD GD" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      TH.MNR_MEAS_UT_CD = GD.MNR_CD_ID" ).append("\n"); 
		query.append("           AND      GD.PRNT_CD_ID = 'CD00010'" ).append("\n"); 
		query.append("           AND      A.TRF_NO = TH.TRF_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) AS MNR_MEAS_UT_NM" ).append("\n"); 
		query.append("FROM     MNR_AGMT_HDR A" ).append("\n"); 
		query.append("       , MDM_VENDOR B" ).append("\n"); 
		query.append("       , MNR_PARTNER D" ).append("\n"); 
		query.append("       , MNR_GEN_CD E" ).append("\n"); 
		query.append("       , MNR_AGMT_APLY_OFC C" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND      A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND      A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND      A.AGMT_VER_NO = C.AGMT_VER_NO" ).append("\n"); 
		query.append("AND      C.APLY_OFC_CD = D.CTRL_OFC_CD" ).append("\n"); 
		query.append("AND      A.VNDR_SEQ = D.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND      A.EQ_KND_CD = E.MNR_CD_ID" ).append("\n"); 
		query.append("AND      A.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND      D.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("AND      E.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("AND      C.APLY_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${tp_cd} == 'EST')" ).append("\n"); 
		query.append("AND      A.EXP_DT >= TRUNC(SYSDATE) - 60" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.VNDR_LGL_ENG_NM" ).append("\n"); 

	}
}