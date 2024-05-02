/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JointOperationLetterDBDAOJooCntcMbrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOJooCntcMbrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationLetterDBDAOJooCntcMbrVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOJooCntcMbrVORSQL").append("\n"); 
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
		query.append("SELECT JO_CRR_CD" ).append("\n"); 
		query.append("      ,CRR_CNTC_SEQ" ).append("\n"); 
		query.append("      ,CNTC_PSON_NM" ).append("\n"); 
		query.append("     -- ,CUST_CNT_CD" ).append("\n"); 
		query.append("     -- ,CUST_SEQ" ).append("\n"); 
		query.append("      ,SVC_IN_CHG_NM" ).append("\n"); 
		query.append("      ,JO_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,JO_CNTC_FAX_NO" ).append("\n"); 
		query.append("      ,JO_CNTC_EML" ).append("\n"); 
		query.append("      ,JO_CNTC_OFC_ADDR" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("  FROM JOO_CNTC_MBR" ).append("\n"); 
		query.append(" WHERE JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 

	}
}