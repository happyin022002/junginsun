/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAORlaneCurrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.13 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAORlaneCurrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade변경시 Rlane과 fin. maxtrix의 currency정보를 가져온다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAORlaneCurrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAORlaneCurrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     distinct" ).append("\n"); 
		query.append("	 a.rlane_cd     as code," ).append("\n"); 
		query.append("	 c.locl_curr_cd as name," ).append("\n"); 
		query.append("     b.jo_crr_auth_cd as auth_cd" ).append("\n"); 
		query.append("FROM joo_carrier  a," ).append("\n"); 
		query.append("     joo_crr_auth b," ).append("\n"); 
		query.append("     joo_finc_mtx c" ).append("\n"); 
		query.append("WHERE a.delt_flg = 'N'" ).append("\n"); 
		query.append("and   b.delt_flg = 'N'" ).append("\n"); 
		query.append("and   a.jo_crr_cd = b.jo_crr_cd" ).append("\n"); 
		query.append("and   a.rlane_cd  = b.rlane_cd" ).append("\n"); 
		query.append("and   b.auth_ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("and   a.jo_crr_cd = c.jo_crr_cd(+)" ).append("\n"); 
		query.append("and   a.rlane_cd  = c.rlane_cd (+)" ).append("\n"); 
		query.append("and   c.re_divr_cd(+)    = @[name]" ).append("\n"); 
		query.append("and   c.jo_stl_itm_cd(+) = @[code]" ).append("\n"); 
		query.append("AND	  a.jo_crr_cd = @[super_cd1]" ).append("\n"); 
		query.append("AND	  a.trd_cd    = @[super_cd2]" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 

	}
}