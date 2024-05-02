/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOUsrIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.09.11 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOUsrIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public JointOperationLetterDBDAOUsrIdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOUsrIdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.USR_NM name,B.USR_ID code" ).append("\n"); 
		query.append("FROM JOO_LTR_TMPLT A, COM_USER B" ).append("\n"); 
		query.append("WHERE A.CRE_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND A.JO_LTR_TP_CD = @[jo_ltr_tp_cd]" ).append("\n"); 

	}
}