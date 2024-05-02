/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchCmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.12.05 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchCmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchCmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchCmInfoRSQL").append("\n"); 
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
		query.append("WITH CONV AS " ).append("\n"); 
		query.append("(SELECT ATTR_CTNT1, ATTR_CTNT2" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNT_CD(+) = 'NL'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID(+) = 'HS_CD'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TO_CHAR(CGO.EDI_SEQ) CM_SEQ_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(CGO.PCK_QTY) CM_PKG_NO" ).append("\n"); 
		query.append("      ,NVL(PCK.CSTMS_PCK_TP_CD, CGO.PCK_TP_CD) AS CM_PKG_CD" ).append("\n"); 
		query.append("      ,(SELECT AA.PCK_NM" ).append("\n"); 
		query.append("          FROM MDM_PCK_TP AA" ).append("\n"); 
		query.append("         WHERE PCK_CD = NVL(PCK.CSTMS_PCK_TP_CD, CGO.PCK_TP_CD)" ).append("\n"); 
		query.append("       ) AS CM_PKG_DESC" ).append("\n"); 
		query.append("      ,SUBSTR(DECODE(CGO.HAMO_TRF_CD, CONV.ATTR_CTNT1, CONV.ATTR_CTNT2, CGO.HAMO_TRF_CD),1,4) CM_HS_CD --HS CODE의 경우 Customs Common Code에 등록된 값이 있을 경우 그것으로 치환" ).append("\n"); 
		query.append("      ,BKG_TOKEN_NL_FNC(CGO.CNTR_MF_DESC, 0, '') CM_DESC" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(CGO.CNTR_WGT_UT_CD, 'LBS', ROUND(NVL(CGO.CNTR_MF_WGT,0)*0.4536,0), CGO.CNTR_MF_WGT) ) CM_WGT" ).append("\n"); 
		query.append("      ,'KGS' CM_WGT_U" ).append("\n"); 
		query.append("      ,CGO.CNTR_NO CM_CNTR_NO" ).append("\n"); 
		query.append("      ,BKG_TOKEN_NL_FNC(CGO.CNTR_MF_MK_DESC, 0, '') MARKNO" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_CGO_MF CGO, BKG_CSTMS_PCK_TP_CONV PCK, CONV" ).append("\n"); 
		query.append(" WHERE CGO.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("   AND CGO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND PCK.CNT_CD(+) = 'NL'" ).append("\n"); 
		query.append("   AND PCK.PCK_TP_CD(+) = CGO.PCK_TP_CD" ).append("\n"); 
		query.append("   AND CONV.ATTR_CTNT1(+) = CGO.HAMO_TRF_CD" ).append("\n"); 
		query.append("ORDER BY CGO.EDI_SEQ" ).append("\n"); 

	}
}