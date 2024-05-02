/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractDAOSearchContractTypeListByContractRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.06.02 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSearchContractTypeListByContractRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchContractTypeListByContractRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchContractTypeListByContractRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("INTG_CD_VAL_CTNT	CODE," ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC NAME" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("#if(${type_flag} != '')" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT IN (#foreach($TYPE_FLAG IN ${lstTYPE_FLAG})" ).append("\n"); 
		query.append("#if($lstTYPE_FLAG.hasNext()) '$TYPE_FLAG', #else '$TYPE_FLAG' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration ").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSearchContractTypeListByContractRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}