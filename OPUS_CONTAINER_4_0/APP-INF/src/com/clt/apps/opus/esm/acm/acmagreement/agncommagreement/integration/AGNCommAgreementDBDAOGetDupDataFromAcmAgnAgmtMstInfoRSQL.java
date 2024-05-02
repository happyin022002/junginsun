/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementDBDAOGetDupDataFromAcmAgnAgmtMstInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOGetDupDataFromAcmAgnAgmtMstInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommAgreementDBDAOGetDupDataFromAcmAgnAgmtMstInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.integration").append("\n");
		query.append("FileName : AGNCommAgreementDBDAOGetDupDataFromAcmAgnAgmtMstInfoRSQL").append("\n");
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
		query.append("SELECT DECODE(DATE_ERR_CNT, 0, 'N', 'Y') AS DATE_ERR_CHK" ).append("\n");
		query.append("  FROM (SELECT COUNT(*) DATE_ERR_CNT " ).append("\n");
		query.append("          FROM ACM_AGN_AGMT_MST " ).append("\n");
		query.append("         WHERE AGN_CD = @[agn_cd]" ).append("\n");
		query.append("           AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("           AND AGN_AGMT_NO <> @[agn_agmt_no]" ).append("\n");
		query.append("           AND ((@[agmt_fm_dt] BETWEEN AGMT_FM_DT AND AGMT_TO_DT) OR" ).append("\n");
		query.append("                (@[agmt_to_dt] BETWEEN AGMT_FM_DT AND AGMT_TO_DT) OR" ).append("\n");
		query.append("                (AGMT_FM_DT BETWEEN @[agmt_fm_dt] AND @[agmt_to_dt]) OR" ).append("\n");
		query.append("                (AGMT_TO_DT BETWEEN @[agmt_fm_dt] AND @[agmt_to_dt])" ).append("\n");
		query.append("               )" ).append("\n");
		query.append("       ) A" ).append("\n");

	}
}