/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlPseudoVslInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier :
*@LastVersion : 1.0
* 2010.01.27
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlPseudoVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCdlPseudoVslInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlPseudoVslInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_edi_msg_func",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_area_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlPseudoVslInfoRSQL").append("\n");
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
		query.append("SELECT	'BRAC:'||NVL(DECODE(@[in_edi_msg_func], 'ORIGINAL','O', 'REPLACE','U', 'CANCEL','C', 'O'),'O')||CHR(10)||" ).append("\n");
		query.append("'VVD:'||SUBSTR(@[in_vvd_cd],1,4)||SUBSTR(@[in_vvd_cd],5,4)||SUBSTR(@[in_vvd_cd],9,1)||CHR(10)||" ).append("\n");
		query.append("'VSL_CALLSIGN:'||CHR(10)||" ).append("\n");
		query.append("'VSL_LLOYDCODE:'||CHR(10)||" ).append("\n");
		query.append("'VSL_FULLNAME:'||NVL(A.VSL_ENG_NM,' ')||CHR(10)||" ).append("\n");
		query.append("'LANE_CD:'||CHR(10)||" ).append("\n");
		query.append("'VVD_REF_NO:'||CHR(10)||" ).append("\n");
		query.append("'PORT:'||NVL(DECODE(@[in_pol_cd],NULL,@[in_pod_cd],@[in_pol_cd]),'')||CHR(10)||" ).append("\n");
		query.append("'PORTNAME:'||NVL(@[in_loc_nm],'')||CHR(10)||" ).append("\n");
		query.append("'ETA:'||CHR(10)||" ).append("\n");
		query.append("'ETD:'||CHR(10)||" ).append("\n");
		query.append("'NEXTPORT:'||CHR(10)||" ).append("\n");
		query.append("'NEXTPORT_ETA:'||CHR(10)||" ).append("\n");
		query.append("'PREVPORT:'||CHR(10)||" ).append("\n");
		query.append("'PREVPORT_ETD:'||CHR(10)||" ).append("\n");
		query.append("'IO_IND:'||'CDL'||CHR(10)||" ).append("\n");
		query.append("'COMP_ID:'||@[in_area_id]||CHR(10)||" ).append("\n");
		query.append("'MRN:'||NVL(A.CRR_CD,' ')||CHR(10)||" ).append("\n");
		query.append("'MRN_NAME:'||NVL(B.CRR_NM,' ')||CHR(10)||" ).append("\n");
		query.append("'CRN_NO:'||CHR(10) PSEUDO_VVD" ).append("\n");
		query.append("FROM MDM_VSL_CNTR A, MDM_CARRIER B" ).append("\n");
		query.append("WHERE A.VSL_CD(+) = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND   A.CRR_CD    = B.CRR_CD" ).append("\n");

	}
}