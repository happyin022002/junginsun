/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAOChargeCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOChargeCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mdm_charge 테이블 조회
	  * </pre>
	  */
	public PRICommonDBDAOChargeCdListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOChargeCdListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD AS CD," ).append("\n"); 
		query.append("	   CHG_NM AS NM  " ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   CHG_CD <> 'OFT'" ).append("\n"); 
		query.append("#if (${etc1} != '')" ).append("\n"); 
		query.append("AND   CHG_CD = @[etc1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CD NOT IN(" ).append("\n"); 
		query.append("				SELECT NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("				FROM PRI_NOTE_CONV_RULE" ).append("\n"); 
		query.append("				WHERE  NOTE_CONV_RULE_CD <> 'ADD' " ).append("\n"); 
		query.append("				)   " ).append("\n"); 
		query.append("ORDER BY CHG_CD ASC" ).append("\n"); 

	}
}