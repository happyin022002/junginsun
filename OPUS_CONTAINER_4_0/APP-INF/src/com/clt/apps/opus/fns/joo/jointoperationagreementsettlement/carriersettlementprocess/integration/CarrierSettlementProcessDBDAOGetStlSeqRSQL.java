/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetStlSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.22 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetStlSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_SETTLEMENT.STL_SEQ Max값 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetStlSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetStlSeqRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(A XPKJOO_SETTLEMENT)*/" ).append("\n"); 
		query.append("A.STL_SEQ + 1 AS STL_SEQ" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT A" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = @[stl_vvd_seq]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}