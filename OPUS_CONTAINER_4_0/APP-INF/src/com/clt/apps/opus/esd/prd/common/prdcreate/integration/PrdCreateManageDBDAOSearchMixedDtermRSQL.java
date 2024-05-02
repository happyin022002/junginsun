/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdCreateManageDBDAOSearchMixedDtermRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2010.09.28 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOSearchMixedDtermRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMixedDterm
	  * histroy
	  * 2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
	  * </pre>
	  */
	public PrdCreateManageDBDAOSearchMixedDtermRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOSearchMixedDtermRSQL").append("\n"); 
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
		query.append("CASE WHEN CNT > 0" ).append("\n"); 
		query.append("THEN (SELECT dTerm" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DISTINCT DE_TERM_CD dTerm, DECODE(DE_TERM_CD, 'D',1,'S',2,'Y',3,'T',4,5) ORD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("ORDER BY ORD)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT (CASE WHEN P.CNT > 0 THEN 'D' ELSE 'Y' END) dTerm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM PRD_NODE" ).append("\n"); 
		query.append("WHERE LOC_CD = @[del]" ).append("\n"); 
		query.append("AND NOD_TP_CD = 'Z'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append(") P)" ).append("\n"); 
		query.append("END dTerm" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkgNo])" ).append("\n"); 

	}
}