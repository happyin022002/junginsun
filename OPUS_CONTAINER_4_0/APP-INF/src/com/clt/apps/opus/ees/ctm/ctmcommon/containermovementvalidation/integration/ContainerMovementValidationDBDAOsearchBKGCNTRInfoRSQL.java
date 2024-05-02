/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAOsearchBKGCNTRInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.25 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KyungMin Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementValidationDBDAOsearchBKGCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchBKGCNTRInfo
	  * </pre>
	  */
	public ContainerMovementValidationDBDAOsearchBKGCNTRInfoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT CNMV_LVL_NO" ).append("\n");
		query.append("FROM CTM_MVMT_SEQ" ).append("\n");
		query.append("WHERE BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]" ).append("\n");
		query.append("AND MVMT_STS_CD = @[mvmt_sts_cd]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration").append("\n");
		query.append("FileName : ContainerMovementValidationDBDAOsearchBKGCNTRInfoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}