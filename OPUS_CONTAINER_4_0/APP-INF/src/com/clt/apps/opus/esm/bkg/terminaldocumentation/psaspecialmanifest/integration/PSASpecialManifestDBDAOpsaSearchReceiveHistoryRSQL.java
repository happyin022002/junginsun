/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier :
*@LastVersion : 1.0
* 2011.11.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Sent결과를 조회해 온다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n");
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("    PSA_VSL_NM -- psa_vsl_nm" ).append("\n");
		query.append("    ,PSA_EDI_MSG_TP_ID" ).append("\n");
		query.append("    ,MSG_RCV_NO" ).append("\n");
		query.append("    ,RCV_LOG_SEQ" ).append("\n");
		query.append("    ,RCV_LOG_ERR_SEQ" ).append("\n");
		query.append("    ,CSTMS_ERR_ID" ).append("\n");
		query.append("    ,CSTMS_ERR_MSG" ).append("\n");
		query.append("    ,CSTMS_ERR_REF_NO1" ).append("\n");
		query.append("    ,CSTMS_ERR_REF_NO2" ).append("\n");
		query.append("    ,CRE_USR_ID" ).append("\n");
		query.append("    ,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI')  AS CRE_DT" ).append("\n");
		query.append("    ,UPD_USR_ID" ).append("\n");
		query.append("    ,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI')  AS UPD_DT" ).append("\n");
		query.append("    ,IB_VVD_CD" ).append("\n");
		query.append("    ,OB_VVD_CD" ).append("\n");
		query.append("    ,NVL(IB_VVD_CD,OB_VVD_CD) VVD_CD" ).append("\n");
		query.append("    ,CNTR_NO" ).append("\n");
		query.append("    ,CNTR_HNDL_KND_CD" ).append("\n");
		query.append("    ,ERR_CNTR_STS_CD" ).append("\n");
		query.append("    ,TNK_CNTR_TPSZ_FLG" ).append("\n");
		query.append("    ,TTL_PCK_QTY" ).append("\n");
		query.append("    ,TTL_PCK_TP_NM" ).append("\n");
		query.append("    ,DG_TTL_WGT" ).append("\n");
		query.append("    ,IMO_NO" ).append("\n");
		query.append("    ,IMDG_UN_NO" ).append("\n");
		query.append("    ,CNTR_TTL_KNT" ).append("\n");
		query.append("    ,CNTR_TTL_ERR_KNT" ).append("\n");
		query.append("    ,CNTR_TTL_SCS_KNT" ).append("\n");
		query.append("FROM BKG_CSTMS_PSA_DG_RCV_ERR" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("#if (${snd_dt_from} != '') " ).append("\n");
		query.append("AND   CRE_DT >=  TO_DATE(REPLACE(@[snd_dt_from],'-',''), 'YYYYMMDD') AND CRE_DT < TO_DATE(REPLACE(@[snd_dt_to],'-',''), 'YYYYMMDD') + 1" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("ORDER BY MSG_RCV_NO DESC, RCV_LOG_SEQ, RCV_LOG_ERR_SEQ" ).append("\n");

	}
}