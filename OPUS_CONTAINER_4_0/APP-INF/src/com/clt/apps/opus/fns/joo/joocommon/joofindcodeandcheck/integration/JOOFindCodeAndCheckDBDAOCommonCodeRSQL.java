/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCommonCodeRSQL.java
*@FileTitle : Entry and Inquiry of Basic Port Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.20 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JOOFindCodeAndCheckDBDAOCommonCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통코드조회
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCommonCodeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("intg_cd_val_dp_desc as name" ).append("\n"); 
		query.append("from com_intg_cd_dtl" ).append("\n"); 
		query.append("where intg_cd_id = @[super_cd1]" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("and	intg_cd_val_ctnt = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and	to_char(sysdate,'yyyymmdd') between aply_st_dt and aply_end_dt" ).append("\n"); 
		query.append("order by intg_cd_val_dp_seq" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.common.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCommonCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}