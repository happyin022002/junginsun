/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOVskCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.22 박희동
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
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOVskCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vsk_carrier에서 carrier code의 유효성 체크
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOVskCarrierRSQL(){
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
		query.append("FileName : JOOFindCodeAndCheckDBDAOVskCarrierRSQL").append("\n"); 
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
		query.append("       CRR_CD AS CODE," ).append("\n"); 
		query.append("       CRR_NM AS NAME" ).append("\n"); 
		query.append("--2010.01.22 VSK_CARRIER 테이블이 drop 됨에 따라 MDM_CARRIER로 변경" ).append("\n"); 
		query.append("FROM   MDM_CARRIER        " ).append("\n"); 
		query.append("WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${code} != '')" ).append("\n"); 
		query.append("AND    CRR_CD = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}