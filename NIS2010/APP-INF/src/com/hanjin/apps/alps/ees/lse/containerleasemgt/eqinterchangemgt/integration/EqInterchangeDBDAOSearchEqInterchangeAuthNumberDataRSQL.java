/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOSearchEqInterchangeAuthNumberDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOSearchEqInterchangeAuthNumberDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auth No list를 조회를 한다.
	  * </pre>
	  */
	public EqInterchangeDBDAOSearchEqInterchangeAuthNumberDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOSearchEqInterchangeAuthNumberDataRSQL").append("\n"); 
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
		query.append("SELECT B.LSE_ITCHG_AUTH_NO AUTH_NO" ).append("\n"); 
		query.append("FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("AND A.LSE_ITCHG_AUTH_SEQ =  B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("--AND B.LSE_ITCHG_AUTH_NO IS NULL" ).append("\n"); 
		query.append("AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("AND A.LCC_CD  = @[loc_fm]" ).append("\n"); 
		query.append("AND A.LR_VNDR_SEQ =  @[vndr_seq]" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM < 50" ).append("\n"); 
		query.append("GROUP BY B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("ORDER BY B.LSE_ITCHG_AUTH_NO  DESC" ).append("\n"); 

	}
}