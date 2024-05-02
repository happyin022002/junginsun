/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOLccCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOLccCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LCC Combo Setting Value
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOLccCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOLccCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.LCC_CD" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY A" ).append("\n"); 
		query.append("  , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("  , CIM_EQ_SPLS_DFCT_RHQ C" ).append("\n"); 
		query.append("  , MDM_SUBCONTINENT N" ).append("\n"); 
		query.append(" WHERE A.CNT_CD = SUBSTR(B.LCC_CD,1,2)" ).append("\n"); 
		query.append("   AND A.SCONTI_CD = N.SCONTI_CD" ).append("\n"); 
		query.append("   AND B.RCC_CD = C.RCC_CD" ).append("\n"); 
		query.append("#if (${sconti_cd} != 'ALL' && ${sconti_cd} != '')   " ).append("\n"); 
		query.append("   AND A.SCONTI_CD = @[sconti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq_cd} != 'ALL' && ${rhq_cd} != '')" ).append("\n"); 
		query.append("   AND C.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY B.LCC_CD" ).append("\n"); 

	}
}