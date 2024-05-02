/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchIBDoorDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.11 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchIBDoorDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IB TRO Confirm 시 적용될 Cop Detail 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchIBDoorDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchIBDoorDtlRSQL").append("\n"); 
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
		query.append("SELECT V2.COP_NO, V2.COP_DTL_SEQ," ).append("\n"); 
		query.append("TO_CHAR(V2.ESTM_DT, 'YYYYMMDDHH24MISS') AS ESTM_DT," ).append("\n"); 
		query.append("TO_CHAR(V2.PRE_ESTM_DT, 'YYYYMMDDHH24MISS') AS PRE_ESTM_DT," ).append("\n"); 
		query.append("TO_CHAR(V2.POST_ESTM_DT, 'YYYYMMDDHH24MISS') AS POST_ESTM_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT V1.RN," ).append("\n"); 
		query.append("V1.COP_NO," ).append("\n"); 
		query.append("V1.COP_DTL_SEQ," ).append("\n"); 
		query.append("V1.ACT_CD," ).append("\n"); 
		query.append("V1.ESTM_DT," ).append("\n"); 
		query.append("V1.PRE_ESTM_DT," ).append("\n"); 
		query.append("V1.POST_ESTM_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT V.RN," ).append("\n"); 
		query.append("V.COP_NO," ).append("\n"); 
		query.append("V.COP_DTL_SEQ," ).append("\n"); 
		query.append("V.ACT_CD," ).append("\n"); 
		query.append("V.ESTM_DT ," ).append("\n"); 
		query.append("LAG(V.ESTM_DT, 1) OVER (" ).append("\n"); 
		query.append("ORDER BY RN) PRE_ESTM_DT ," ).append("\n"); 
		query.append("LEAD(V.ESTM_DT, 1) OVER (" ).append("\n"); 
		query.append("ORDER BY RN) POST_ESTM_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM RN," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COP_DTL_SEQ," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("ESTM_DT" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("ORDER BY COP_NO, COP_DTL_SEQ ) V )V1" ).append("\n"); 
		query.append("WHERE ACT_CD = 'FITZAD' ) V2" ).append("\n"); 

	}
}