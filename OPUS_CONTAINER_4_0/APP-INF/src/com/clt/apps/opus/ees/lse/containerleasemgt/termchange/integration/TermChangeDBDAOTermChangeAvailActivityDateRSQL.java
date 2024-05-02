/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeDBDAOTermChangeAvailActivityDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.12.30 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TermChangeDBDAOTermChangeAvailActivityDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 Activity Date에 대한 유효성을 검증한다.
	  * </pre>
	  */
	public TermChangeDBDAOTermChangeAvailActivityDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration").append("\n"); 
		query.append("FileName : TermChangeDBDAOTermChangeAvailActivityDateRSQL").append("\n"); 
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
		query.append("SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, B.EFF_DT, B.EXP_DT" ).append("\n"); 
		query.append("FROM    LSE_AGREEMENT A," ).append("\n"); 
		query.append("LSE_AGMT_VER B" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ =B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[aft_agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[aft_agmt_seq]" ).append("\n"); 
		query.append("AND     TO_DATE(@[act_dt], 'YYYYMMDD') BETWEEN B.EFF_DT AND B.EXP_DT" ).append("\n"); 

	}
}