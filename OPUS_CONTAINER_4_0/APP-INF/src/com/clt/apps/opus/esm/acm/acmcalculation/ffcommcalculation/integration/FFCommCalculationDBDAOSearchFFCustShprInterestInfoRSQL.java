/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.13
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

public class FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n");
		query.append("FileName : FFCommCalculationDBDAOSearchFFCustShprInterestInfoRSQL").append("\n");
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
		query.append("SELECT '*' FF " ).append("\n");
		query.append("  FROM ACM_FF_EXCLU_SET" ).append("\n");
		query.append(" WHERE ff_cnt_cd = @[bkg_ff_cnt_cd]" ).append("\n");
		query.append("	AND ff_seq = TO_NUMBER(@[bkg_ff_seq]) " ).append("\n");
		query.append("	AND shpr_cnt_cd = @[shpr_cnt_cd] " ).append("\n");
		query.append("	AND shpr_seq = TO_NUMBER(@[shpr_cust_seq])" ).append("\n");

	}
}