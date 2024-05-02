/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL.java
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

public class FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL(){
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
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n");
		query.append("FileName : FFCommCalculationDBDAOSearchOldIfCommFFCodeRSQL").append("\n");
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
		query.append("SELECT OLD_FF_CNT_CD, OLD_FF_SEQ,OLD_SUM_IF_AMT " ).append("\n");
		query.append("FROM ( " ).append("\n");
		query.append("	SELECT BKG_FF_CNT_CD OLD_FF_CNT_CD, " ).append("\n");
		query.append("	       TO_CHAR(BKG_FF_SEQ) OLD_FF_SEQ, " ).append("\n");
		query.append("	       FF_CMPN_STS_CD, " ).append("\n");
		query.append("	       SUBSTR(TO_CHAR(SUM (IF_AMT)),1,15) OLD_SUM_IF_AMT " ).append("\n");
		query.append("	FROM ACM_FF_CMPN " ).append("\n");
		query.append("	WHERE BKG_NO= @[bkg_no]" ).append("\n");
		query.append("	AND BKG_FF_CNT_CD||BKG_FF_SEQ <> @[bkg_ff_cnt_cd]||TO_NUMBER(@[bkg_ff_seq]) " ).append("\n");
		query.append("	GROUP BY BKG_FF_CNT_CD, BKG_FF_SEQ, FF_CMPN_STS_CD " ).append("\n");
		query.append(") " ).append("\n");
		query.append("WHERE OLD_SUM_IF_AMT <> 0 " ).append("\n");
		query.append("AND FF_CMPN_STS_CD = 'IF'" ).append("\n");

	}
}