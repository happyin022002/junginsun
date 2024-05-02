/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDispRlseNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.11.06 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDispRlseNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Sold Creation 저장시 Release No 가 없다면 생성조회한다.
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDispRlseNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDispRlseNoDataRSQL").append("\n"); 
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
		query.append("SELECT C.POST_DISP_RLSE_NO AS DISP_RLSE_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT PRE_DISP_RLSE_NO" ).append("\n"); 
		query.append(", TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(A.DISP_RLSE_NO,LENGTH(A.DISP_RLSE_NO)-2))),0)) POST_DISP_RLSE_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL A" ).append("\n"); 
		query.append(", (SELECT @[ofc_cd]||TO_CHAR(SYSDATE,'YYYYMMDD')||'-' PRE_DISP_RLSE_NO" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("WHERE A.DISP_RLSE_NO LIKE B.PRE_DISP_RLSE_NO || '%'" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}