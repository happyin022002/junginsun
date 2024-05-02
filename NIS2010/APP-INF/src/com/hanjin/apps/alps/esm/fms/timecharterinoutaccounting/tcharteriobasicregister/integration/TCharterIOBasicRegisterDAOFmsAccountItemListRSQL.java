/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOBasicRegisterDAOFmsAccountItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDAOFmsAccountItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBasicRegisterDAOFmsAccountItemListRSQL
	  * </pre>
	  */
	public TCharterIOBasicRegisterDAOFmsAccountItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_acct_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDAOFmsAccountItemListRSQL").append("\n"); 
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
		query.append("	   mi.acct_itm_nm," ).append("\n"); 
		query.append("	   mi.acct_cd, " ).append("\n"); 
		query.append("	   mi.acct_itm_seq" ).append("\n"); 
		query.append("  from fms_acct_cate mc, fms_acct_itm mi" ).append("\n"); 
		query.append(" where mc.flet_acct_cate_cd = @[flet_acct_cate_cd]" ).append("\n"); 
		query.append("   and mc.acct_cd = mi.acct_cd" ).append("\n"); 
		query.append("   and mc.acct_itm_seq = mi.acct_itm_seq" ).append("\n"); 
		query.append("#if (${acct_itm_nm} != '')    " ).append("\n"); 
		query.append("   and Upper(mi.acct_itm_nm) like '%' || Upper(@[acct_itm_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" order by mi.acct_itm_nm " ).append("\n"); 

	}
}