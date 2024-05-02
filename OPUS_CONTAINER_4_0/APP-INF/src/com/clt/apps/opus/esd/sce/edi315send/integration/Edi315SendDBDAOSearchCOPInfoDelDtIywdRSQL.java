/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoDelDtIywdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.22 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoDelDtIywdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoDelDtIywd
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoDelDtIywdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoDelDtIywdRSQL").append("\n"); 
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
		query.append("TO_CHAR(E_T, 'YYYYMMDDHH24MI') DEL_ETA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T, 'GMT'), 'YYYYMMDDHH24MI'))) DEL_ETA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T, 'YYYYMMDDHH24MI') DEL_ATA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T, 'GMT'), 'YYYYMMDDHH24MI'))) DEL_ATA_GMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ESTM_DT E_T," ).append("\n"); 
		query.append("CASE WHEN ACT_DT IS NULL" ).append("\n"); 
		query.append("AND D.ACT_STS_CD = 'F' THEN ESTM_DT ELSE ACT_DT END A_T ," ).append("\n"); 
		query.append("SUBSTR(H.DEL_NOD_CD, 0, 5) NOD ," ).append("\n"); 
		query.append("D.NOD_CD DEL_NOD" ).append("\n"); 
		query.append("FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.DEL_NOD_CD = D.NOD_CD" ).append("\n"); 
		query.append("AND D.ACT_CD = 'FUWMUD'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}