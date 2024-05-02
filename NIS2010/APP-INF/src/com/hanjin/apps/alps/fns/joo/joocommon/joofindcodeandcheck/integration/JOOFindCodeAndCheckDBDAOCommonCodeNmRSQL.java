/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCommonCodeNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.02.27 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOCommonCodeNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CommonCodeNm
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCommonCodeNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCommonCodeNmRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("intg_cd_val_ctnt    as code," ).append("\n"); 
		query.append("INTG_CD_VAL_DESC as name" ).append("\n"); 
		query.append("from com_intg_cd_dtl" ).append("\n"); 
		query.append("where intg_cd_id = @[super_cd1]" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("and	intg_cd_val_ctnt = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and	to_char(sysdate,'yyyymmdd') between aply_st_dt and aply_end_dt" ).append("\n"); 
		query.append("order by intg_cd_val_dp_seq" ).append("\n"); 

	}
}