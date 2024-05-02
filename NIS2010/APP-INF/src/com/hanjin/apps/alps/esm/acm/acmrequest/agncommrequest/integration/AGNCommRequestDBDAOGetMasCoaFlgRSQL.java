/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetMasCoaFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetMasCoaFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMasCoaFlg
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetMasCoaFlgRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetMasCoaFlgRSQL").append("\n"); 
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
		query.append("SELECT DECODE((SELECT /*+ FIRST_ROWS(1) */ BKG_NO" ).append("\n"); 
		query.append("               FROM MAS_BKG_COST_SRC_DTL -- TRS비용 MAS 이관 안됨 -> 대리점 계산할 때 이 결과값이 나오면 MAS에서 원래대로 계산. 안나오면 COA쪽으로 돌려 계산." ).append("\n"); 
		query.append("               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND ROWNUM = 1" ).append("\n"); 
		query.append("              ), @[bkg_no], 'MAS', 'COA'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}