/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOIFETaxDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.21 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOIFETaxDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP I/F Error시 JOO_TAX_DTL을 삭제한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOIFETaxDtlDSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration ").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOIFETaxDtlDSQL").append("\n"); 
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
		query.append("DELETE JOO_TAX_DTL X" ).append("\n"); 
		query.append("WHERE  (TAX_INV_YRMON, OFC_CD, TAX_SER_NO) IN (" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("        TAX_INV_YRMON, OFC_CD, TAX_SER_NO" ).append("\n"); 
		query.append("  FROM   JOO_TAX A" ).append("\n"); 
		query.append("  WHERE  A.SLP_TP_CD   = @[slp_tp_cd]" ).append("\n"); 
		query.append("  AND    A.SLP_FUNC_CD = @[slp_func_cd]" ).append("\n"); 
		query.append("  AND    A.SLP_OFC_CD  = @[slp_ofc_cd]" ).append("\n"); 
		query.append("  AND    A.SLP_ISS_DT  = @[slp_iss_dt]" ).append("\n"); 
		query.append("  AND    A.SLP_SER_NO  = @[slp_ser_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}