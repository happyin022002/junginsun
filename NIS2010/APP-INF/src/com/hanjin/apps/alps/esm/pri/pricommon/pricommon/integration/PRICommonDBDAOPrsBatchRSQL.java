/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOPrsBatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.06
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.06 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mood Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOPrsBatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PRICommonDBDAOPrsBatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_info_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOPrsBatchRSQL").append("\n"); 
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
		query.append("select PGM_NO, PARA_INFO_CTNT, PRS_BAT_SEQ, PRS_BAT_ID, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT , ( SYSDATE - CRE_DT )   * 24 * 60  AS EXEC_MINUTES, PRS_BAT_ERR_VAL" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("	select PGM_NO, PARA_INFO_CTNT, PRS_BAT_SEQ, PRS_BAT_ID, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT ,PRS_BAT_ERR_VAL" ).append("\n"); 
		query.append("	from PRI_PRS_BAT" ).append("\n"); 
		query.append("	where PGM_NO LIKE @[pgm_no] || '%' and  PARA_INFO_CTNT like @[para_info_ctnt] || '%'" ).append("\n"); 
		query.append("	order by CRE_DT DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where ROWNUM =1" ).append("\n"); 

	}
}