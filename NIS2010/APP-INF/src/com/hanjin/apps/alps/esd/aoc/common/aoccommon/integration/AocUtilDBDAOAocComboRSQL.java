/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocUtilDBDAOAocComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AocUtilDBDAOAocComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AOC Combo
	  * </pre>
	  */
	public AocUtilDBDAOAocComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cm_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration ").append("\n"); 
		query.append("FileName : AocUtilDBDAOAocComboRSQL").append("\n"); 
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
		query.append("SELECT   INTG_CD_ID" ).append("\n"); 
		query.append(",        INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",        INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID = @[cm_code]" ).append("\n"); 
		query.append("AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}