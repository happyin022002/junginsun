/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOSearchBunkerInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.02.01 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOSearchBunkerInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOSearchBunkerInterfaceRSQL
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOSearchBunkerInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOSearchBunkerInterfaceRSQL").append("\n"); 
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
		query.append("SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("       BNK_SEQ," ).append("\n"); 
		query.append("	   BNK_YRMON," ).append("\n"); 
		query.append(" 	   BNK_TP_CD," ).append("\n"); 
		query.append(" 	   FB.ACCT_CD," ).append("\n"); 
		query.append(" 	   FB.ACCT_ITM_SEQ," ).append("\n"); 
		query.append(" 	   FA.ACCT_ITM_NM," ).append("\n"); 
		query.append(" 	   BNK_DT," ).append("\n"); 
		query.append(" 	   VSL_CD," ).append("\n"); 
		query.append(" 	   SKD_VOY_NO," ).append("\n"); 
		query.append(" 	   SKD_DIR_CD," ).append("\n"); 
		query.append(" 	   REV_DIR_CD," ).append("\n"); 
		query.append(" 	   PORT_CD," ).append("\n"); 
		query.append("       ROUND(FB.BNK_AMT, 4) TOTAL_AMT, " ).append("\n"); 
		query.append("       FB.VSL_CD||FB.SKD_VOY_NO||FB.SKD_DIR_CD||FB.REV_DIR_CD BUNKER_VVD," ).append("\n"); 
		query.append("	   DECODE(FLET_MEAS_UT_CD, 'M', 'MT','Liter') FLET_MEAS_UT_CD," ).append("\n"); 
		query.append("	   BNK_QTY," ).append("\n"); 
		query.append("	   BNK_PRC_AMT," ).append("\n"); 
		query.append("       DECODE(IF_DT,NULL,'N','Y') IF_DT" ).append("\n"); 
		query.append("  FROM FMS_BUNKER FB, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE BNK_YRMON = @[bnk_yrmon]" ).append("\n"); 
		query.append("   AND FA.ACCT_CD = FB.ACCT_CD" ).append("\n"); 
		query.append("   AND FA.ACCT_ITM_SEQ = FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append(" ORDER BY FB.BNK_TP_CD, FB.ACCT_ITM_SEQ" ).append("\n"); 

	}
}