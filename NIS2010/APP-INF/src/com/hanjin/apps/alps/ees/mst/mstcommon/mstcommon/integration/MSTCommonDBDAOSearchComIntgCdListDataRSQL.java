/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MSTCommonDBDAOSearchComIntgCdListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.03.18 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOSearchComIntgCdListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COM INTG CD DTL 코드 조회용 SQL
	  * </pre>
	  */
	public MSTCommonDBDAOSearchComIntgCdListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration").append("\n"); 
		query.append("FileName : MSTCommonDBDAOSearchComIntgCdListDataRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT AS CODE ," ).append("\n"); 
		query.append("       INTG_CD_VAL_DP_DESC AS CODE_NM" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID =@[intg_cd_id] " ).append("\n"); 
		query.append("#if (${intg_cd_val} != '')" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT =@[intg_cd_val] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}