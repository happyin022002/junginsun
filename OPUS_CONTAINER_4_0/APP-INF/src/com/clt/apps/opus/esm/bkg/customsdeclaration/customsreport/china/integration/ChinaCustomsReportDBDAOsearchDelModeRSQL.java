/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsReportDBDAOsearchDelModeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsReportDBDAOsearchDelModeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 중국 DEL 별 운송 Mode 조회.
	  * </pre>
	  */
	public ChinaCustomsReportDBDAOsearchDelModeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration").append("\n");
		query.append("FileName : ChinaCustomsReportDBDAOsearchDelModeRSQL").append("\n");
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
		query.append("SELECT POD_CD" ).append("\n");
		query.append(", AREA_NM" ).append("\n");
		query.append(", DEL_CD" ).append("\n");
		query.append(", CHN_CSTMS_TRSP_MOD_CD AS TRSP_MOD_CD" ).append("\n");
		query.append(", DIFF_RMK" ).append("\n");
		query.append("FROM BKG_CSTMS_CHN_DE_MOD" ).append("\n");
		query.append("WHERE POD_CD  LIKE    @[pod_cd]||'%'" ).append("\n");
		query.append("AND   DEL_CD  LIKE	  @[del_cd]||'%'" ).append("\n");

	}
}