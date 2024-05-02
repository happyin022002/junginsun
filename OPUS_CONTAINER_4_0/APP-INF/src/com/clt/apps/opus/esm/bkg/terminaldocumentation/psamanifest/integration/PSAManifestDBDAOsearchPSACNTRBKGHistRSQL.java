/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSACNTRBKGHistRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.08
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSACNTRBKGHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PSA BKG 전송 결과 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSACNTRBKGHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n");
		query.append("FileName : PSAManifestDBDAOsearchPSACNTRBKGHistRSQL").append("\n");
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
		query.append("SELECT BKG_NO" ).append("\n");
		query.append(", BKG_SEQ" ).append("\n");
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n");
		query.append(", N1ST_SHPR_NM" ).append("\n");
		query.append(", POD_CD" ).append("\n");
		query.append(", N1ST_POD_CD" ).append("\n");
		query.append(", N2ND_POD_CD" ).append("\n");
		query.append(", N3RD_POD_CD" ).append("\n");
		query.append(", TO_CHAR( SND_DT, 'YYYY-MM-DD' ) SND_DT" ).append("\n");
		query.append(", SND_USR_ID" ).append("\n");
		query.append(", TO_CHAR( RCV_DT, 'YYYY-MM-DD' ) RCV_DT" ).append("\n");
		query.append(", ACK_RCV_STS_CD" ).append("\n");
		query.append("FROM BKG_CSTMS_PSA_BKG" ).append("\n");
		query.append("WHERE SND_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n");
		query.append("#if(${bkg_no}!='')" ).append("\n");
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${vvd}!='')" ).append("\n");
		query.append("AND VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${pod_cd}!='')" ).append("\n");
		query.append("AND POD_CD = @[pod_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if(${status}!='')" ).append("\n");
		query.append("AND ACK_RCV_STS_CD = @[status]" ).append("\n");
		query.append("#end" ).append("\n");

	}
}