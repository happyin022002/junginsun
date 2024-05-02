/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.02.19 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCsrOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR OFFICE CODE distinct
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrOfcRSQL").append("\n"); 
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
		query.append("/*2010.02.19 박효숙 차장 SLP_OFC_CD, SLP_ISS_OFC_CD 로 조회하므로  */" ).append("\n"); 
		query.append("SELECT DISTINCT SLP_OFC_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.SLP_OFC_CD" ).append("\n"); 
		query.append("FROM   JOO_CSR A" ).append("\n"); 
		query.append("WHERE  A.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${gubun} == '0')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif(${gubun} == '1')" ).append("\n"); 
		query.append("AND    A.EFF_DT  >= TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.EFF_DT  <= TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       A.SLP_ISS_OFC_CD AS SLP_OFC_CD" ).append("\n"); 
		query.append("FROM   JOO_CSR A" ).append("\n"); 
		query.append("WHERE  A.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${gubun} == '0')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif(${gubun} == '1')" ).append("\n"); 
		query.append("AND    A.EFF_DT  >= TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.EFF_DT  <= TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}