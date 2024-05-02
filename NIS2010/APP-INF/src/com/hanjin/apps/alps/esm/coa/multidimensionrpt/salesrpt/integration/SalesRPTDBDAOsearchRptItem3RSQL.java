/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOsearchRptItem3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.11.06 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchRptItem3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _SPCL_REPO_CNTR_RGST 테이블의 데이터 조회
	  * 
	  * 관련 Table :  BKG Info, BKG Cost DTL
	  * 관련 검색 정보 :  BKG Info에 조건을 건다. Searching BKG NO,TP SZ로  BKG Cost Detal Table에서
	  *                              세부 Node/Link별   cost 비용을 항목별로 보여준다.
	  * </pre>
	  */
	public SalesRPTDBDAOsearchRptItem3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchRptItem3RSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("#if(${f_rd_ind} != 'Y' )" ).append("\n"); 
		query.append("SPCL_CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(CNTR_TPSZ_CD, 'R2', 'RD2', 'R4', 'RD4', SPCL_CNTR_TPSZ_CD) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM    COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("WHERE   NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND     SPCL_CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("ORDER   BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}