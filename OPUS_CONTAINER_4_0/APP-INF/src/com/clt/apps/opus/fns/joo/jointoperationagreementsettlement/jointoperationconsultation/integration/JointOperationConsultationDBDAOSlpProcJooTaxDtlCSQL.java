/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlpProcJooTaxDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.05 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlpProcJooTaxDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR Creation시 JOO_TAX_DTL에 데이타 입력
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlpProcJooTaxDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_inv_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("itm_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlpProcJooTaxDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_TAX_DTL (" ).append("\n"); 
		query.append("TAX_INV_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",TAX_SER_NO" ).append("\n"); 
		query.append(",TAX_SEQ" ).append("\n"); 
		query.append(",ITM_NM" ).append("\n"); 
		query.append(",SPL_AMT" ).append("\n"); 
		query.append(",TAX_AMT" ).append("\n"); 
		query.append(",TTL_AMT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[tax_inv_yrmon]" ).append("\n"); 
		query.append(",@[ofc_cd]" ).append("\n"); 
		query.append(",@[tax_ser_no]" ).append("\n"); 
		query.append(",NVL((" ).append("\n"); 
		query.append("SELECT /*+INDEX_DESC(A XPKJOO_TAX_DTL)*/" ).append("\n"); 
		query.append("A.TAX_SEQ + 1" ).append("\n"); 
		query.append("FROM   JOO_TAX_DTL A" ).append("\n"); 
		query.append("WHERE  A.TAX_INV_YRMON = @[tax_inv_yrmon]" ).append("\n"); 
		query.append("AND    A.OFC_CD        = @[ofc_cd]" ).append("\n"); 
		query.append("AND    A.TAX_SER_NO    = @[tax_ser_no]" ).append("\n"); 
		query.append("AND    ROWNUM = 1),1)" ).append("\n"); 
		query.append(",@[itm_nm]" ).append("\n"); 
		query.append(",@[spl_amt]" ).append("\n"); 
		query.append(",@[tax_amt]" ).append("\n"); 
		query.append(",@[ttl_amt]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}