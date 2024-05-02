/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAONoteConvRuleMapgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAONoteConvRuleMapgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NOTE_CONV_RULE_CD
	  * PRI_NOTE_CONV_TP_RULE_MAPG
	  * 조인해서 해당 데이터만 조회
	  * </pre>
	  */
	public PRICommonDBDAONoteConvRuleMapgListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT    A.NOTE_CONV_RULE_CD CD" ).append("\n"); 
		query.append(", A.NOTE_CONV_RULE_NM NM" ).append("\n"); 
		query.append("FROM PRI_NOTE_CONV_RULE A" ).append("\n"); 
		query.append(", PRI_NOTE_CONV_TP_RULE_MAPG B" ).append("\n"); 
		query.append("WHERE A.NOTE_CONV_RULE_CD = B.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("AND B.PRC_CTRT_TP_CD = @[etc1]" ).append("\n"); 
		query.append("AND B.NOTE_CONV_TP_CD =  @[etc2]" ).append("\n"); 
		query.append("ORDER BY A.NOTE_CONV_RULE_CD ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAONoteConvRuleMapgListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}