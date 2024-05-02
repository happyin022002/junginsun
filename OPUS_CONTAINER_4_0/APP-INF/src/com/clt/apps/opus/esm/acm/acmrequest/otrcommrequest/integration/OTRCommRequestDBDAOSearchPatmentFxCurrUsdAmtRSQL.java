/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOSearchPatmentFxCurrUsdAmtRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.08.30 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOSearchPatmentFxCurrUsdAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchPatmentFxCurrUsdAmt
	  * </pre>
	  */
	public OTRCommRequestDBDAOSearchPatmentFxCurrUsdAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_if_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration ").append("\n");
		query.append("FileName : OTRCommRequestDBDAOSearchPatmentFxCurrUsdAmtRSQL").append("\n");
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
		query.append("	ROUND(@[pay_if_amt],2) AS PAY_IF_AMT," ).append("\n");
		query.append("    NVL(MAX(M.FX_CURR_RT),0) AS PAY_XCH_RT," ).append("\n");
		query.append("	ROUND(@[pay_if_amt] / NVL(MAX(M.FX_CURR_RT),0) ,2) AS USD_AMT" ).append("\n");
		query.append("FROM ACM_OFC_INFO I, MDM_ORGANIZATION M" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND I.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("AND REPLACE(@[aply_dt],'-', '') BETWEEN I.AGN_FM_DT AND I.AGN_TO_DT" ).append("\n");
		query.append("AND I.AGN_CD = M.OFC_CD" ).append("\n");
		query.append("AND I.XCH_RT_DIV_LVL = 4" ).append("\n");
		query.append("AND M.BIL_CURR_CD = @[curr_cd]" ).append("\n");
		query.append("AND ROWNUM = 1" ).append("\n");

	}
}