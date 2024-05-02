/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : INVCommonDBDAOsearchAccountExrateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOsearchAccountExrateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAccountExrate
	  * </pre>
	  */
	public INVCommonDBDAOsearchAccountExrateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchAccountExrateRSQL").append("\n"); 
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
		query.append("SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), '0') EX_RATE" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	WHERE A.ACCT_XCH_RT_YRMON = (SELECT  /*+index( B XPKBKG_VVD) */ MIN(SUBSTR(TO_CHAR(A.VPS_ETD_DT, 'yyyymmdd'), 1, 6))" ).append("\n"); 
		query.append("                            	 FROM VSK_VSL_PORT_SKD A, BKG_VVD B" ).append("\n"); 
		query.append("                           		 WHERE 1 = 1" ).append("\n"); 
		query.append("                             	 AND B.BKG_NO           = @[bkg_no]                      " ).append("\n"); 
		query.append("                             	 AND A.VSL_CD(+)       = B.VSL_CD" ).append("\n"); 
		query.append("                             	 AND A.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                            	 AND A.SKD_DIR_CD(+)    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                             	 AND A.VPS_PORT_CD(+)    = B.POL_CD" ).append("\n"); 
		query.append("                             	 AND A.CLPT_IND_SEQ(+)  = '1'" ).append("\n"); 
		query.append("                             	 AND A.VPS_ETD_DT IS NOT NULL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    WHERE A.ACCT_XCH_RT_YRMON = (SELECT SUBSTR(TO_CHAR(VPS_ETD_DT, 'yyyymmdd'), 1, 6)" ).append("\n"); 
		query.append("  								 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" 								 WHERE VSL_CD = @[vsl]" ).append("\n"); 
		query.append("   								 AND SKD_VOY_NO = @[voy]" ).append("\n"); 
		query.append("  								 AND SKD_DIR_CD = @[dep]" ).append("\n"); 
		query.append("  								 AND VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("  								 AND CLPT_IND_SEQ ='1'" ).append("\n"); 
		query.append("  								 AND VPS_ETD_DT IS NOT NULL)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND A.CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("AND B.CURR_CD = @[curr]" ).append("\n"); 

	}
}