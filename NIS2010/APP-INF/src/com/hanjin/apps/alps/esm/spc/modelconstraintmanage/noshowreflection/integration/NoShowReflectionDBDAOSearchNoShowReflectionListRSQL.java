/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NoShowReflectionDBDAOSearchNoShowReflectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NoShowReflectionDBDAOSearchNoShowReflectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * No-Show 반영기준 데이터 조회
	  * </pre>
	  */
	public NoShowReflectionDBDAOSearchNoShowReflectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration").append("\n"); 
		query.append("FileName : NoShowReflectionDBDAOSearchNoShowReflectionListRSQL").append("\n"); 
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
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         A.TRD_CD           ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD       ," ).append("\n"); 
		query.append("         A.RLANE_CD         ," ).append("\n"); 
		query.append("         A.DIR_CD           ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_BSE_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_CS_CD  ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_TGT_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_MOD_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_MOD_VAL " ).append("\n"); 
		query.append("    FROM SPC_NSHW_RFLT A" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD           ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD       ," ).append("\n"); 
		query.append("         A.DIR_CD           ," ).append("\n"); 
		query.append("         A.RLANE_CD         ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_BSE_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_CS_CD  ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_TGT_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_MOD_CD ," ).append("\n"); 
		query.append("         A.ALOC_DDCT_MOD_VAL" ).append("\n"); 

	}
}