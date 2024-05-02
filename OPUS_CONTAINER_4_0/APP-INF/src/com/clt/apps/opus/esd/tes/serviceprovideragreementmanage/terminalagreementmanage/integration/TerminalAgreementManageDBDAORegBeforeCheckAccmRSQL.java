/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.05 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accm select
	  * </pre>
	  */
	public TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAORegBeforeCheckAccmRSQL").append("\n"); 
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
		query.append("SELECT	a.vndr_seq" ).append("\n"); 
		query.append("FROM	TES_TML_SO_ACCM_MZD a, TES_TML_SO_ACCM_YD b, TES_TML_SO_ACCM_COST c" ).append("\n"); 
		query.append("WHERE	a.vndr_seq	= @[vndr_seq]" ).append("\n"); 
		query.append("AND		b.yd_cd		= @[yd_cd]" ).append("\n"); 
		query.append("AND		c.lgs_cost_cd = @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND		a.vndr_seq	= b.vndr_seq" ).append("\n"); 
		query.append("AND		a.vndr_seq	= c.vndr_seq" ).append("\n"); 
		query.append("AND		a.accm_seq	= b.accm_seq" ).append("\n"); 
		query.append("AND		a.accm_seq	= c.accm_seq" ).append("\n"); 

	}
}