/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupDBDAOSearchDeptListRSQL.java
*@FileTitle : Evaluator Inquiry Choice
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.04 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PopupDBDAOSearchDeptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조직트리룰 조회한다
	  * </pre>
	  */
	public PopupDBDAOSearchDeptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.popup.integration").append("\n"); 
		query.append("FileName : PopupDBDAOSearchDeptListRSQL").append("\n"); 
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
		query.append("#if(${efpt_ofc_cd}=='A')" ).append("\n"); 
		query.append("SELECT LEVEL AS SLEVEL" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("         WHERE INTG_CD_ID ='CD03373' " ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT =A.OFC_CD" ).append("\n"); 
		query.append("         ) AS DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR A.OFC_CD = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH A.OFC_CD IN (SELECT INTG_CD_VAL_CTNT  AS OFC_CD" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID ='CD03373'      " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("ORDER SIBLINGS BY DP_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT LEVEL AS SLEVEL, OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("START WITH OFC_CD=@[efpt_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER SIBLINGS BY OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}