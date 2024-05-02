/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLMReceiveEAIDBDAOSearchCLMReceiveEAICNMVRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLMReceiveEAIDBDAOSearchCLMReceiveEAICNMVRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCLMReceiveEAICNMV
	  * </pre>
	  */
	public CLMReceiveEAIDBDAOSearchCLMReceiveEAICNMVRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.clmreceiveeai.integration").append("\n"); 
		query.append("FileName : CLMReceiveEAIDBDAOSearchCLMReceiveEAICNMVRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(C XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("C.CNTR_NO,C.CNMV_YR,C.CNMV_ID_NO,C.CNMV_CYC_NO" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(I.CLM_SEQ),0)+1 FROM SCE_CLM_IF I" ).append("\n"); 
		query.append("WHERE I.CNTR_NO LIKE @[CNTR_NO] ||'%'" ).append("\n"); 
		query.append("AND   I.CNMV_YR = C.CNMV_YR" ).append("\n"); 
		query.append("AND   I.CNMV_ID_NO = C.CNMV_ID_NO" ).append("\n"); 
		query.append("AND   I.CLM_CYC_NO = C.CNMV_CYC_NO) CLM_SEQ" ).append("\n"); 
		query.append("FROM  CTM_MOVEMENT C" ).append("\n"); 
		query.append("WHERE C.CNTR_NO LIKE @[CNTR_NO] ||'%'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}