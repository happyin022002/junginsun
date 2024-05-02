/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOAddFFCommChgDetailBFCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FF_CMPN_REV" ).append("\n"); 
		query.append("(BKG_NO, BKG_FF_CNT_CD, BKG_FF_SEQ, FF_CMPN_SEQ, CHG_CD, BKG_CHG_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT   @[bkg_no], @[bkg_ff_cnt_cd], @[bkg_ff_seq], @[ff_cmpn_seq], CHG_CD, SUM(CHG_AMT)," ).append("\n"); 
		query.append("        'FF System', SYSDATE, 'FF System', SYSDATE" ).append("\n"); 
		query.append("   FROM BKG_CHG_RT" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("    AND CURR_CD = 'USD'" ).append("\n"); 
		query.append("	AND CHG_CD IN ('OFT') " ).append("\n"); 
		query.append("GROUP BY CHG_CD" ).append("\n"); 

	}
}