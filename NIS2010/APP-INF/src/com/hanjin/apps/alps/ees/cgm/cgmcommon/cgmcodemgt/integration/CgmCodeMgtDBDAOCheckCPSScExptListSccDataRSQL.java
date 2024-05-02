/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOCheckCPSScExptListSccDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.02 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOCheckCPSScExptListSccDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 SCC가 유효한 값인지 체크한다.
	  * </pre>
	  */
	public CgmCodeMgtDBDAOCheckCPSScExptListSccDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOCheckCPSScExptListSccDataRSQL").append("\n"); 
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
		query.append("SELECT SCC_CD" ).append("\n"); 
		query.append("FROM(SELECT ML.SCC_CD " ).append("\n"); 
		query.append("     FROM MDM_LOCATION ML, MDM_COUNTRY MC, MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("     AND ML.CNT_CD = MC.CNT_CD(+)" ).append("\n"); 
		query.append("     AND ML.SCC_CD = ME.SCC_CD(+)" ).append("\n"); 
		query.append("     AND NVL(ML.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("     AND NVL(MC.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("WHERE SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}