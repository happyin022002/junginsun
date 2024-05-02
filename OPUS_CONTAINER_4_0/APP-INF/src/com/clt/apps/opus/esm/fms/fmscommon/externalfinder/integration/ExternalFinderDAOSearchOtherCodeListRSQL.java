/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ExternalFinderDAOSearchOtherCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDAOSearchOtherCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OtherCodeList 를 조회한다.
	  * </pre>
	  */
	public ExternalFinderDAOSearchOtherCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDAOSearchOtherCodeListRSQL").append("\n"); 
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
		query.append("PPT_NM," ).append("\n"); 
		query.append("PPT_SEQ," ).append("\n"); 
		query.append("PPT_CTNT," ).append("\n"); 
		query.append("PPT_NM org_ppt_nm," ).append("\n"); 
		query.append("PPT_SEQ org_ppt_seq" ).append("\n"); 
		query.append("FROM FMS_PPT_SET" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${code_tp} != 'ALL')" ).append("\n"); 
		query.append("WHERE PPT_NM = @[code_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY PPT_NM , PPT_SEQ, PPT_CTNT" ).append("\n"); 

	}
}