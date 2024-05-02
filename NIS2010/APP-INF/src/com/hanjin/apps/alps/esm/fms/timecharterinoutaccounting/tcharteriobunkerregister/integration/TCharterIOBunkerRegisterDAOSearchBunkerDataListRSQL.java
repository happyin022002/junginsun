/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOSearchBunkerDataListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOSearchBunkerDataListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOSearchBunkerDataListRSQL
	  * [CHM-201005117-01]
	  * 구매 ERP쪽으로 송신할 데이타를 가져온다
	  * 단 항차 : 'VV', 'MM'으로 끝나는 항차는 제외
	  *     계정코드 : 956115(정산_BOD/BOR) 코드만 조회 by 정윤태
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOSearchBunkerDataListRSQL(){
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
		query.append("FileName : TCharterIOBunkerRegisterDAOSearchBunkerDataListRSQL").append("\n"); 
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
		query.append("SELECT  FLET_CTRT_NO" ).append("\n"); 
		query.append("       ,BNK_SEQ" ).append("\n"); 
		query.append("       ,BNK_YRMON" ).append("\n"); 
		query.append("       ,BNK_TP_CD" ).append("\n"); 
		query.append("       ,FB.ACCT_CD" ).append("\n"); 
		query.append("       ,FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("       ,FA.ACCT_ITM_NM" ).append("\n"); 
		query.append("       ,BNK_DT" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,REV_DIR_CD" ).append("\n"); 
		query.append("       ,PORT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(ROUND(FB.BNK_AMT, 4),'FM999999999999990.0000') TOTAL_AMT" ).append("\n"); 
		query.append("       ,   FB.VSL_CD " ).append("\n"); 
		query.append("        || FB.SKD_VOY_NO " ).append("\n"); 
		query.append("        || FB.SKD_DIR_CD " ).append("\n"); 
		query.append("        || FB.REV_DIR_CD BUNKER_VVD" ).append("\n"); 
		query.append("       ,DECODE(FLET_MEAS_UT_CD, 'M', 'MT','Liter') FLET_MEAS_UT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(BNK_QTY,'FM999999999999990.000') BNK_QTY" ).append("\n"); 
		query.append("       ,TO_CHAR(ROUND(BNK_PRC_AMT,4),'FM999999999999990.0000') BNK_PRC_AMT" ).append("\n"); 
		query.append("  FROM FMS_BUNKER FB, FMS_ACCT_ITM FA" ).append("\n"); 
		query.append(" WHERE BNK_YRMON = @[bnk_yrmon]" ).append("\n"); 
		query.append("   AND FA.ACCT_CD = FB.ACCT_CD" ).append("\n"); 
		query.append("   AND FA.ACCT_ITM_SEQ = FB.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("   AND FB.ACCT_CD = '956115'" ).append("\n"); 
		query.append("   AND FB.SKD_DIR_CD || FB.REV_DIR_CD != 'VV'" ).append("\n"); 
		query.append("   AND FB.SKD_DIR_CD || FB.REV_DIR_CD != 'MM'" ).append("\n"); 
		query.append(" ORDER BY FB.BNK_TP_CD, FB.ACCT_ITM_SEQ" ).append("\n"); 

	}
}