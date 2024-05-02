/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchCalcDtlCntrHandlingFeeListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchCalcDtlCntrHandlingFeeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchCalcDtlCntrHandlingFeeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n");
		query.append("FileName : AGNCommRequestDBDAOSearchCalcDtlCntrHandlingFeeListRSQL").append("\n");
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
		query.append("SELECT (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'x'||OP_CNTR_QTY" ).append("\n");
		query.append("                              FROM BKG_QUANTITY" ).append("\n");
		query.append("                             WHERE BKG_NO = A.BKG_NO))) AS CNTR_TPSZ_QTY," ).append("\n");
		query.append("       A.COMM_FX_AMT||'/Box' AS COMM_FX_AMT," ).append("\n");
		query.append("       A.IF_AMT AS IF_AMT" ).append("\n");
		query.append("  FROM ACM_AGN_COMM A" ).append("\n");
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n");
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n");
		query.append("   AND A.AC_TP_CD = 'H'" ).append("\n");

	}
}