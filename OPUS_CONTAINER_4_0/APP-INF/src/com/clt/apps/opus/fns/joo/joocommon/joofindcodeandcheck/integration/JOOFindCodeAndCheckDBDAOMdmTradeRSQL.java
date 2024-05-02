/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOMdmTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOMdmTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM TRADE조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOMdmTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOMdmTradeRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	trd_cd as code," ).append("\n"); 
		query.append("	trd_nm as name" ).append("\n"); 
		query.append("from mdm_trade" ).append("\n"); 
		query.append("where 1=1 --vsl_tp_cd = 'C'" ).append("\n"); 
		query.append("and	delt_flg = 'N'" ).append("\n"); 
		query.append("and trd_cd <> 'COM'" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("and	trd_cd = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by trd_cd" ).append("\n"); 

	}
}