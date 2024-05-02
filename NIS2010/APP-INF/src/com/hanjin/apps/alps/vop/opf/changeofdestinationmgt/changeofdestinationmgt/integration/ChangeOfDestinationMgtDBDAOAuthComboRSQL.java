/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOAuthComboRSQL.java
*@FileTitle : Multi Trade Account Group
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOAuthComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------------------
	  * 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOAuthComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOAuthComboRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",      INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT ' ' INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      ,      'All' INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("      ,      0 INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("      FROM   DUAL" ).append("\n"); 
		query.append("      UNION" ).append("\n"); 
		query.append("      SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      ,      INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("      ,      INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("      FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("      WHERE  INTG_CD_ID = 'CD02124'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ ASC" ).append("\n"); 

	}
}