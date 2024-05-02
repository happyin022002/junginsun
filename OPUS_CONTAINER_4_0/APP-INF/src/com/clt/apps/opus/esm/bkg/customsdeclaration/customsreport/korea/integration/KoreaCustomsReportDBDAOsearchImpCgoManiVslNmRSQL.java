/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchImpCgoManiVslNmRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.05 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchImpCgoManiVslNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Import Cargo Manifest Print를 위한 VSL Information을 조회한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchImpCgoManiVslNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOsearchImpCgoManiVslNmRSQL").append("\n");
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
		query.append("SELECT NVL(VSL_ENG_NM,' ') VSL_ENG_NM" ).append("\n");
		query.append(", NVL(CALL_SGN_NO,' ') CALL_SGN_NO" ).append("\n");
		query.append(", NVL(VSL_RGST_CNT_CD,' ') VSL_RGST_CNT_CD" ).append("\n");
		query.append(", CNT.CNT_NM CNT_NM" ).append("\n");
		query.append("FROM MDM_VSL_CNTR CNTR, MDM_COUNTRY CNT" ).append("\n");
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("AND VSL_RGST_CNT_CD = CNT.CNT_CD" ).append("\n");

	}
}