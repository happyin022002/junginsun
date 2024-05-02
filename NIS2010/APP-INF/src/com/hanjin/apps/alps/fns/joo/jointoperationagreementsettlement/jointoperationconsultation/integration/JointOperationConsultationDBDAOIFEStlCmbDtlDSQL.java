/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOIFEStlCmbDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.21 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOIFEStlCmbDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP I/F Error시 Reject 처리하면 JOO_STL_CMB_DTL을 삭제한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOIFEStlCmbDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOIFEStlCmbDtlDSQL").append("\n"); 
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
		query.append("DELETE JOO_STL_CMB_DTL" ).append("\n"); 
		query.append("WHERE (ACCT_YRMON, JO_CRR_CD, STL_CMB_SEQ, RE_DIVR_CD) IN" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT " ).append("\n"); 
		query.append("             ACCT_YRMON, JO_CRR_CD, STL_CMB_SEQ, RE_DIVR_CD" ).append("\n"); 
		query.append("      FROM   JOO_STL_CMB A" ).append("\n"); 
		query.append("      WHERE  A.SLP_TP_CD   = @[slp_tp_cd]" ).append("\n"); 
		query.append("      AND    A.SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("      AND    A.SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("      AND    A.SLP_ISS_DT  = @[slp_iss_dt]" ).append("\n"); 
		query.append("      AND    A.SLP_SER_NO  = @[slp_ser_no]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}