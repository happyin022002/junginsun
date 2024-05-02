/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaDBDAOCheckYardSurplusAreaAuthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurplusAreaDBDAOCheckYardSurplusAreaAuthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MT Inventory Simulation by Yard 화면에 대한 수정 권한을 체크한다.
	  * </pre>
	  */
	public SurplusAreaDBDAOCheckYardSurplusAreaAuthRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.integration").append("\n"); 
		query.append("FileName : SurplusAreaDBDAOCheckYardSurplusAreaAuthRSQL").append("\n"); 
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
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN EXISTS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN B.SCC_CD IS NOT NULL" ).append("\n"); 
		query.append("    THEN 'N'" ).append("\n"); 
		query.append("    ELSE 'Y'" ).append("\n"); 
		query.append("    END AUTH_CHK" ).append("\n"); 
		query.append("    FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND M.LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("    AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("    AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    AND M.AR_HD_QTR_OFC_CD = 'SINWA'" ).append("\n"); 
		query.append("    AND B.RCC_CD = 'SGSIN'" ).append("\n"); 
		query.append("    AND ((B.LCC_CD = 'AEDXB' AND B.ECC_CD IN ('BHKBS','KWKWI','QADOH')) OR (B.LCC_CD IN ('IDJKT','MYPKG','PHMNL','SGSIN','THBKK','VNSGN')))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END AUTH_CHK" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND M.OFC_CD = UPPER(TRIM(@[ofc_cd]))" ).append("\n"); 
		query.append("AND NVL(M.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("),'X') AUTH_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}