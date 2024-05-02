/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAOSearchCheckForBeforeAmendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.24 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOSearchCheckForBeforeAmendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.22 추가 <br>
	  * 구주 Hinterland 프로젝트에 따른 변경 사항 <br>
	  * 구주 Hinterland 프로젝트 오픈 이전에 발생한 AEW, AEE에 대해서는 Ament 불가<br>
	  * </pre>
	  */
	public PRICommonDBDAOSearchCheckForBeforeAmendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOSearchCheckForBeforeAmendRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.PROP_NO) CNT" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_MN A" ).append("\n"); 
		query.append(" WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("       AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("       AND A.SVC_SCP_CD IN ('AEE', 'AEW')" ).append("\n"); 

	}
}