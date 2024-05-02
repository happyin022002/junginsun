/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOCheckContinentTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.09 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOCheckContinentTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 두 Country 의 Continent 가 동일한지를 비교해주는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOCheckContinentTypeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	COUNT(C.CONTI_CD) CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_COUNTRY A" ).append("\n"); 
		query.append(",   MDM_SUBCONTINENT B" ).append("\n"); 
		query.append(",   MDM_CONTINENT C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.CNT_CD = @[fnl_dest_cnt_cd]" ).append("\n"); 
		query.append("AND A.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND B.CONTI_CD = C.CONTI_CD" ).append("\n"); 
		query.append("AND C.CONTI_CD = (" ).append("\n"); 
		query.append("SELECT	C.CONTI_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_COUNTRY A" ).append("\n"); 
		query.append(",   MDM_SUBCONTINENT B" ).append("\n"); 
		query.append(",   MDM_CONTINENT C" ).append("\n"); 
		query.append("WHERE	A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND A.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("AND B.CONTI_CD = C.CONTI_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration ").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOCheckContinentTypeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}