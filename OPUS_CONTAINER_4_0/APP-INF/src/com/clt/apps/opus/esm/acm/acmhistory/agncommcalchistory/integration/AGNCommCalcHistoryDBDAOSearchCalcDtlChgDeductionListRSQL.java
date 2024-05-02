/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlChgDeductionListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier :
*@LastVersion : 1.0
* 2012.07.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalcHistoryDBDAOSearchCalcDtlChgDeductionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommCalcHistoryDBDAOSearchCalcDtlChgDeductionListRSQL(){
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
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration").append("\n");
		query.append("FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlChgDeductionListRSQL").append("\n");
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
		query.append("SELECT A.CHG_CD," ).append("\n");
		query.append("       ROUND(A.CHG_DDCT_PAY_AMT, 2) AS CHG_DDCT_PAY_AMT," ).append("\n");
		query.append("       CURR_CD," ).append("\n");
		query.append("       ROUND(A.CHG_DDCT_AMT, 2) AS CHG_DDCT_AMT" ).append("\n");
		query.append("  FROM ACM_AGN_COMM_CHG_HIS A," ).append("\n");
		query.append("       BKG_BOOKING B" ).append("\n");
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n");
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n");
		query.append("   AND A.AC_TP_CD <> 'T'" ).append("\n");
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n");
		query.append("   AND A.CALC_NO = @[calc_no]" ).append("\n");
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n");

	}
}