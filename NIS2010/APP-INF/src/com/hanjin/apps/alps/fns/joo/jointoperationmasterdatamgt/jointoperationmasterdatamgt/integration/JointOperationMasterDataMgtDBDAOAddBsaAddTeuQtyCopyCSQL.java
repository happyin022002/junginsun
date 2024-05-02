/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOAddBsaAddTeuQtyCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOAddBsaAddTeuQtyCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA Entry화면에서 Row copy시 ADD BSA도 자동 생성되도록 한다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOAddBsaAddTeuQtyCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_ref_no_copy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOAddBsaAddTeuQtyCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_BSA_ADD_CRR" ).append("\n"); 
		query.append("SELECT @[jo_bsa_ref_no]" ).append("\n"); 
		query.append(", JO_CRR_CD" ).append("\n"); 
		query.append(", JO_BSA_ADD_REF_SEQ" ).append("\n"); 
		query.append(", JO_BSA_TEU_QTY" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append("FROM JOO_BSA_ADD_CRR" ).append("\n"); 
		query.append("WHERE JO_BSA_REF_NO = @[jo_bsa_ref_no_copy]" ).append("\n"); 
		query.append("AND JO_VER_FLG = 'Y'" ).append("\n"); 

	}
}