/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOCustCdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.09.15 함대성
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

public class JointOperationLetterDBDAOCustCdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public JointOperationLetterDBDAOCustCdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOCustCdInfoRSQL").append("\n"); 
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
		query.append("SELECT C.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("A.BZET_ADDR" ).append("\n"); 
		query.append(",'' CUSTOMER_CODE" ).append("\n"); 
		query.append(",'' jo_crr_cd" ).append("\n"); 
		query.append(",'' crr_cntc_seq" ).append("\n"); 
		query.append(",'' cntc_pson_nm" ).append("\n"); 
		query.append(",'' svc_in_chg_nm" ).append("\n"); 
		query.append(",'' jo_cntc_phn_no" ).append("\n"); 
		query.append(",'' jo_cntc_fax_no" ).append("\n"); 
		query.append(",'' jo_cntc_eml" ).append("\n"); 
		query.append(",'' jo_cntc_ofc_addr" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER C, MDM_CUST_ADDR A" ).append("\n"); 
		query.append("WHERE C.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND C.CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}