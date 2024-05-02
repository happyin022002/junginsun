/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOInvMcsLetterVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOInvMcsLetterVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public JointOperationLetterDBDAOInvMcsLetterVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOInvMcsLetterVORSQL").append("\n"); 
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
		query.append("SELECT A.JO_LTR_SEQ," ).append("\n"); 
		query.append("A.JO_LTR_NO," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("(SELECT S1.JO_CRR_CD FROM JOO_LTR_STL S1 WHERE S1.JO_LTR_SEQ= A.JO_LTR_SEQ AND ROWNUM=1)JO_CRR_CD," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("DECODE(A.JO_LTR_TP_CD, 'M', 'MCS', 'I', 'Invoice') JO_LTR_TP_CD," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("'' from_dt," ).append("\n"); 
		query.append("'' to_dt" ).append("\n"); 
		query.append("FROM JOO_LETTER A" ).append("\n"); 
		query.append("WHERE TO_CHAR(A.LTR_ISS_DT,'YYYYMMDD') BETWEEN  @[from_dt] AND @[to_dt]" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'Y' FROM JOO_LTR_STL S1 WHERE S1.JO_LTR_SEQ= A.JO_LTR_SEQ AND S1.JO_CRR_CD = @[jo_crr_cd] AND ROWNUM=1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY  A.CRE_DT DESC" ).append("\n"); 

	}
}