/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAONextStlSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.24 박희동
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

public class CarrierSettlementProcessDBDAONextStlSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Settlement에 입력할 때 STL_SEQ +1을 채번한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAONextStlSeqRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAONextStlSeqRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC(X XPKJOO_SETTLEMENT)*/" ).append("\n"); 
		query.append("       X.STL_SEQ + 1 AS STL_CMB_SEQ" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT X" ).append("\n"); 
		query.append("WHERE  X.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    X.STL_VVD_SEQ = TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("AND    ROWNUM        = 1" ).append("\n"); 

	}
}