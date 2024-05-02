/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOSearchMixedTermNodeValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.09.27 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOSearchMixedTermNodeValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rcvT/por 혹은 delT/del 을 매개변수로 쿼리를 실행하여 Y or N 값을 리턴 하게 됩니다
	  * </pre>
	  */
	public PrdCreateManageDBDAOSearchMixedTermNodeValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nodCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration ").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOSearchMixedTermNodeValidationRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[term],'D',DECODE(COUNT(*),0,'N','Y'),DECODE(COUNT(*),0,'Y','N')) term" ).append("\n"); 
		query.append("FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE NOD_CD = @[nodCd]" ).append("\n"); 
		query.append("AND NOD_TP_CD = 'Z'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'X') <> 'Y'" ).append("\n"); 

	}
}