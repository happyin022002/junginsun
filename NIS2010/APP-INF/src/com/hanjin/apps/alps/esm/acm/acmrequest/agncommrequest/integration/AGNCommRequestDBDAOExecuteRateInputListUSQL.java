/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOExecuteRateInputListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.24 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOExecuteRateInputListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommRequestDBDAOExecuteRateInputListUSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOExecuteRateInputListUSQL").append("\n"); 
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
		query.append("UPDATE ACM_AGN_COMM U" ).append("\n"); 
		query.append("       SET" ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("           U.PAY_XCH_RT," ).append("\n"); 
		query.append("           U.PAY_CRNT_AMT," ).append("\n"); 
		query.append("           U.PAY_IF_AMT," ).append("\n"); 
		query.append("           U.UPD_USR_ID," ).append("\n"); 
		query.append("           U.UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         =" ).append("\n"); 
		query.append("         (     " ).append("\n"); 
		query.append("                 SELECT" ).append("\n"); 
		query.append("                      TO_NUMBER(@[pay_xch_rt]) AS PAY_XCH_RT," ).append("\n"); 
		query.append("                 CASE A.CURR_CD" ).append("\n"); 
		query.append("                     WHEN 'JPY' THEN ROUND (A.CRNT_AMT * TO_NUMBER(@[pay_xch_rt]), 0)" ).append("\n"); 
		query.append("                     WHEN 'TWD' THEN ROUND (A.CRNT_AMT * TO_NUMBER(@[pay_xch_rt]), 0)" ).append("\n"); 
		query.append("                     ELSE ROUND (A.CRNT_AMT * TO_NUMBER(@[pay_xch_rt]), 2)" ).append("\n"); 
		query.append("                  END                     AS PAY_CRNT_AMT," ).append("\n"); 
		query.append("                 CASE A.CURR_CD" ).append("\n"); 
		query.append("                     WHEN 'JPY' THEN ROUND (A.IF_AMT * TO_NUMBER(@[pay_xch_rt]), 0)" ).append("\n"); 
		query.append("                     WHEN 'TWD' THEN ROUND (A.IF_AMT * TO_NUMBER(@[pay_xch_rt]), 0)" ).append("\n"); 
		query.append("                     ELSE ROUND (A.IF_AMT * TO_NUMBER(@[pay_xch_rt]), 2)" ).append("\n"); 
		query.append("                  END                     AS PAY_IF_AMT," ).append("\n"); 
		query.append("                      @[usr_id]           AS UPD_USR_ID," ).append("\n"); 
		query.append("                      SYSDATE             AS UPD_DT" ).append("\n"); 
		query.append("                 FROM ACM_AGN_COMM A" ).append("\n"); 
		query.append("                WHERE A.BKG_NO       = U.BKG_NO" ).append("\n"); 
		query.append("                  AND A.AGN_CD       = U.AGN_CD" ).append("\n"); 
		query.append("                  AND A.IO_BND_CD    = U.IO_BND_CD" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD    <> 'T'" ).append("\n"); 
		query.append("                  AND A.AC_SEQ       = U.AC_SEQ" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD     = U.AC_TP_CD" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      WHERE U.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND U.AGN_CD       = @[agn_cd]" ).append("\n"); 
		query.append("        AND U.IO_BND_CD    = @[io_bnd_cd]" ).append("\n"); 
		query.append("        AND U.AC_TP_CD    <> 'T'" ).append("\n"); 
		query.append("        AND U.AC_SEQ       = @[ac_seq]" ).append("\n"); 

	}
}