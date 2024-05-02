/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Tariff Registration 팝업 Hidden Sheet 조회 쿼리
	  * 
	  * History
	  * 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	CONTI_CD" ).append("\n"); 
		query.append(",	DVS_FEE_TP_CD" ).append("\n"); 
		query.append(",	DIR_CD" ).append("\n"); 
		query.append(",	DVS_FEE_AMT" ).append("\n"); 
		query.append("FROM OPF_COD_DVS_FEE" ).append("\n"); 
		query.append("ORDER BY CONTI_CD, DVS_FEE_TP_CD, DIR_CD" ).append("\n"); 

	}
}