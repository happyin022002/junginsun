/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOmodifyAddBsaQtyCarrieListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.12 
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

public class JointOperationMasterDataMgtDBDAOmodifyAddBsaQtyCarrieListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Carrier의 TEU 값을 Main에 Update 해주기 전에 초기화 해준다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOmodifyAddBsaQtyCarrieListUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOmodifyAddBsaQtyCarrieListUSQL").append("\n"); 
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
		query.append("UPDATE JOO_BSA_INFO_ENTR" ).append("\n"); 
		query.append("SET JO_BSA_ADD_TEU_QTY =  '0'" ).append("\n"); 
		query.append("WHERE JO_BSA_REF_NO =  @[jo_bsa_ref_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND JO_VER_FLG = 'Y'" ).append("\n"); 

	}
}