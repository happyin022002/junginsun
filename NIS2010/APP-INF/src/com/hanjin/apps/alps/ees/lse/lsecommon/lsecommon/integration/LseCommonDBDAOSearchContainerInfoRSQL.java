/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonDBDAOSearchContainerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.11.18 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchContainerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Info Search.
	  * </pre>
	  */
	public LseCommonDBDAOSearchContainerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration ").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchContainerInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append(", AGMT_CTY_CD" ).append("\n"); 
		query.append(", AGMT_SEQ" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", ONH_CNTR_STS_CD" ).append("\n"); 
		query.append(", TO_CHAR(ONH_DT, 'YYYYMMDD') AS ONH_DT" ).append("\n"); 
		query.append(", ONH_YD_CD" ).append("\n"); 
		query.append(", ONH_FREE_DYS" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", LSTM_CD" ).append("\n"); 
		query.append("FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}