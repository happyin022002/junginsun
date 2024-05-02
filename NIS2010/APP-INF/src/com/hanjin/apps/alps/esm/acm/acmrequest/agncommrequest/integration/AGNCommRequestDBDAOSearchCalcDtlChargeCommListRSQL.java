/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchCalcDtlChargeCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchCalcDtlChargeCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Calc Dtl Charge Comm List
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchCalcDtlChargeCommListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchCalcDtlChargeCommListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("     , DECODE(IO_BND_CD, 'O', 'O/B', 'I/B') AS IO_BND_CD" ).append("\n"); 
		query.append("     , CHG_UT_AMT" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , RAT_UT_CD" ).append("\n"); 
		query.append("     , CHG_AMT" ).append("\n"); 
		query.append("     , DECODE(CHG_COMM_RT, '', CHG_COMM_OTR_AMT, CHG_COMM_RT) AS CHG_COMM_RT" ).append("\n"); 
		query.append("     , DECODE(CHG_COMM_RT, '', CHG_COMM_CURR_CD, '%') AS CHG_COMM_CURR_CD" ).append("\n"); 
		query.append("     , PAY_COMM_AMT" ).append("\n"); 
		query.append("     , COMM_AMT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM_DTL_CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("   AND AC_TP_CD = 'P'" ).append("\n"); 
		query.append(" ORDER BY AC_CHG_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}