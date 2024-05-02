/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOCarrierByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.15 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOCarrierByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Carrier조회(Trade, Lane 조회조건)
	  * 2010.11.08 이준범 [CHM-201006731-01]
	  *  1. 대상 기능
	  *    - JO Member Information Creation(JOO_0066)
	  *    - Inquiry of JO Member Information(JOO_0067)
	  *  2. 보완 대상
	  *    - Revenue Lane 정보 반영 
	  *    - MS Office( Excel, Worl, Power Point등) 첨부
	  *    - Carrier Name등 컬럼 반영
	  *  3. 목 적
	  *    - 그동안 Excel로 관리되던  선사별 이력 관리를 시스템내에서 관리하도록 하며
	  *    - Pending 사항에 대한 등록을 통해 선사별  Pending 사항이 간과 , 누락되지 않도록 함
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOCarrierByLaneRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOCarrierByLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A.JO_CRR_CD AS NAME" ).append("\n"); 
		query.append("      ,A.RLANE_CD  AS CODE" ).append("\n"); 
		query.append("  FROM JOO_CARRIER  A," ).append("\n"); 
		query.append("       JOO_CRR_AUTH B" ).append("\n"); 
		query.append(" WHERE A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD  = B.RLANE_CD " ).append("\n"); 
		query.append("   AND B.AUTH_OFC_CD = NVL(@[ofc_cd],B.AUTH_OFC_CD)" ).append("\n"); 
		query.append("   AND A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 
		query.append("        ,NAME" ).append("\n"); 

	}
}