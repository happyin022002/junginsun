/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchCurrentOftListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchCurrentOftListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 BKG에 반영되어 있는 Interface Charge 정보를 조회한다.
	  * </pre>
	  */
	public BlRatingDBDAOSearchCurrentOftListRSQL(){
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchCurrentOftListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       RAT_UT_CD," ).append("\n"); 
		query.append("       CHG_AMT CRNT_CHG_AMT," ).append("\n"); 
		query.append("       0 AMD_CHG_AMT," ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CHG_RT R" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("AND AUTO_RAT_CD = 'I'" ).append("\n"); 
		query.append("AND CRE_DT = (SELECT MAX(CRE_DT)" ).append("\n"); 
		query.append("              FROM BKG_CHG_RT T" ).append("\n"); 
		query.append("              WHERE T.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("              AND T.CHG_CD = R.CHG_CD)" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}