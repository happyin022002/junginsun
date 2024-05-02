/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAOInPriRateAdjustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.04 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOInPriRateAdjustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에서 sheet의 내용을 읽어 오기 위해 VO를 만들기 위한 쿼리다.
	  * sheet의 내용은 mapping을 위한 데이터이기 때문에 특정 table과 매칭 되지 않는다.
	  * 또한 조회없이 입력만 하는 sheet이기 때문에 따로 VO가 필요하다.
	  * </pre>
	  */
	public RFARateQuotationDBDAOInPriRateAdjustListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOInPriRateAdjustListRSQL").append("\n"); 
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
		query.append("'' AS PER" ).append("\n"); 
		query.append(", '' AS CARGO" ).append("\n"); 
		query.append(", '' AS CURRENCY" ).append("\n"); 
		query.append(", '' AS AMOUNT" ).append("\n"); 
		query.append(", '' AS PERCENT" ).append("\n"); 
		query.append(", '' AS QTTN_NO" ).append("\n"); 
		query.append(", '' AS QTTN_VER_NO" ).append("\n"); 
		query.append(", '' AS GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(", '' AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", '' AS PARENTS_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}