/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SettlementClaimDBDAOSearchSettlementExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.11.26 박제성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Je Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOSearchSettlementExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement 입력수정 결정
	  * </pre>
	  */
	public SettlementClaimDBDAOSearchSettlementExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.integration ").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOSearchSettlementExistRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'M'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ' ')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("||" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'S'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_CGO_CLM_STL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CGO_CLM_NO = @[cgo_clm_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ' ')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append(")EXIST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 

	}
}