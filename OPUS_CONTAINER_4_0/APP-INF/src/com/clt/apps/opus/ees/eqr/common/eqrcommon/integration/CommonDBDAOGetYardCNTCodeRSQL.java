/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOGetYardCNTCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetYardCNTCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Code의 Country code 를 검색해 옵니다.
	  * </pre>
	  */
	public CommonDBDAOGetYardCNTCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetYardCNTCodeRSQL").append("\n"); 
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
		query.append("CNT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST A," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("AND   B.SCC_CD = @[yard_code]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N' -- 09.08.04 검색조건 추가 (삭제되지 않은 ECC만 조회) 기존버그 수정 By ChungEunHo" ).append("\n"); 

	}
}