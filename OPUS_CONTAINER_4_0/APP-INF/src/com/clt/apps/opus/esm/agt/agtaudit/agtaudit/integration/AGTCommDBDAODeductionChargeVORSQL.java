/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommDBDAODeductionChargeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommDBDAODeductionChargeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0012 화면 Deducted Charge 조회
	  * </pre>
	  */
	public AGTCommDBDAODeductionChargeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTCommDBDAODeductionChargeVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT	X.CHG_CD AS CHG_CD," ).append("\n"); 
		query.append("NVL(X.BKG_AGMT_UT_CD,'XX') AS BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("NVL(X.CURR_CD, Y.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("ROUND(DECODE(X.CHG_DDCT_LOCL_AMT, 0,	Y.ROUT_TRF_RT, X.CHG_DDCT_LOCL_AMT), 2) AS CHG_DDCT_LOCL_AMT," ).append("\n"); 
		query.append("ROUND(X.CHG_DDCT_AMT,2) AS CHG_DDCT_AMT" ).append("\n"); 
		query.append("FROM (SELECT A.BKG_NO, A.CHG_CD, A.BKG_AGMT_UT_CD, A.CHG_DDCT_AMT," ).append("\n"); 
		query.append("A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.AC_SEQ," ).append("\n"); 
		query.append("DECODE(B.DCGO_FLG, 'Y','DG'," ).append("\n"); 
		query.append("DECODE(B.RC_FLG,	 'Y','RF'," ).append("\n"); 
		query.append("DECODE(B.AWK_CGO_FLG,'Y','AK'," ).append("\n"); 
		query.append("DECODE(B.BB_CGO_FLG, 'Y','BB', ' ')))) CGO_FLG," ).append("\n"); 
		query.append("A.CURR_CD CURR_CD," ).append("\n"); 
		query.append("A.CHG_DDCT_LOCL_AMT" ).append("\n"); 
		query.append("FROM AGT_CHG_DDCT_REF	A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE A.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("AND A.AGN_CD			= @[agn_cd]" ).append("\n"); 
		query.append("AND A.IO_BND_CD		= @[io_bnd_cd]" ).append("\n"); 
		query.append("AND A.AC_TP_CD		<> 'T'" ).append("\n"); 
		query.append("AND A.AC_SEQ			= @[ac_seq]" ).append("\n"); 
		query.append("AND A.BKG_NO			= B.BKG_NO" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("AGT_CHG_ROUT_REF	Y" ).append("\n"); 
		query.append("WHERE X.BKG_NO			= Y.BKG_NO(+)" ).append("\n"); 
		query.append("AND X.CHG_CD			= Y.CHG_CD(+)" ).append("\n"); 
		query.append("AND X.BKG_AGMT_UT_CD	= Y.BKG_AGMT_UT_CD(+)" ).append("\n"); 
		query.append("AND X.CGO_FLG		= Y.SPCL_CGO_CTNT(+)" ).append("\n"); 

	}
}