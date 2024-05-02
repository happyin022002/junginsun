/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.24
*@LastModifier :
*@LastVersion : 1.0
* 2013.07.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author janginho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA BKG Release Order의 CNTR Type size조회
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL").append("\n");
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
		query.append("SELECT PSA_SER_NO RO_NO" ).append("\n");
		query.append(", 'D' RO_FI" ).append("\n");
		query.append(", LPAD( PSA_SER_NO, 2, '0' ) RO_SEQ" ).append("\n");
		query.append(", DECODE( YD_CD, 'SGSINAO', 'ACW2','SGSINKS', 'PSC1', 'SGSINAC', 'CUA1', 'SGSINAL', DECODE(substr(CNTR_TPSZ_CD, 1 , 2),'D2', 'ACS3','D4','ACS3','D5','ACS3' )) RO_DO" ).append("\n");
		query.append(", DECODE( CNTR_TPSZ_CD,  'D2', 'GP', 'D4', 'GP'," ).append("\n");
		query.append("'D5', 'HC', 'D7', 'HC'," ).append("\n");
		query.append("'F2', 'FR', 'F4', 'FR'," ).append("\n");
		query.append("'O2', 'OT', 'O4', 'OT'," ).append("\n");
		query.append("'P2', 'PF', 'P4', 'PF'," ).append("\n");
		query.append("'R2', 'RF', 'R4', 'RF'," ).append("\n");
		query.append("'R5', 'RF', 'R7', 'RF', 'R9', 'RF'," ).append("\n");
		query.append("'T2', 'TK', 'T4', 'TK'," ).append("\n");
		query.append("'S2', 'OT', 'S4', 'OT'," ).append("\n");
		query.append("'A2', 'FR', 'A4', 'FR'," ).append("\n");
		query.append("'D8', 'GP', 'D9', 'GP' ) RO_CNTR_TP" ).append("\n");
		query.append(", DECODE( CNTR_TPSZ_CD,  'D2', 'GP', 'D4', 'GP'," ).append("\n");
		query.append("'D5', 'GP', 'D7', 'GP'," ).append("\n");
		query.append("'F2', 'FR', 'F4', 'FR'," ).append("\n");
		query.append("'O2', 'OT', 'O4', 'OT'," ).append("\n");
		query.append("'P2', 'PF', 'P4', 'PF'," ).append("\n");
		query.append("'R2', 'RF', 'R4', 'RF', 'R9', 'RF'," ).append("\n");
		query.append("'R5', 'RF', 'R7', 'RF'," ).append("\n");
		query.append("'T2', 'TK', 'T4', 'TK'," ).append("\n");
		query.append("'S2', 'OT', 'S4', 'OT'," ).append("\n");
		query.append("'A2', 'FR', 'A4', 'FR'," ).append("\n");
		query.append("'D8', 'GP', 'D9', 'GP'  ) CNTR_TP" ).append("\n");
		query.append(", LPAD( CNTR_QTY, 3, '0' ) RO_NO_CNTR" ).append("\n");
		query.append("FROM      BKG_CSTMS_PSA_RLSE_ORD" ).append("\n");
		query.append("WHERE     BKG_NO   =  @[bkg_no]" ).append("\n");
		query.append("AND       BKG_SEQ  =  @[bkg_seq] - 1" ).append("\n");
		query.append("ORDER BY  PSA_SER_NO, SUB_PSA_SER_NO" ).append("\n");

	}
}