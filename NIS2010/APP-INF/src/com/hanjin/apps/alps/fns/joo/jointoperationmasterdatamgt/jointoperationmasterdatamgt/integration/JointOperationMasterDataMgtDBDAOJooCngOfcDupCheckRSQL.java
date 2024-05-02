/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.07
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.12.07 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Mapping 정보 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooCngOfcDupCheckRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("ofc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("joo_cng_ofc a" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${ibflag} == 'U')" ).append("\n"); 
		query.append("and cng_ofc_cd != @[cng_ofc_cd]" ).append("\n"); 
		query.append("AND delt_flg = 'N'" ).append("\n"); 
		query.append("#elseif (${ibflag} == 'I')" ).append("\n"); 
		query.append("and  a.delt_flg = case when	nvl((select 1 from joo_cng_ofc x where x.ofc_cd = @[ofc_cd] and x.cng_ofc_cd = @[cng_ofc_cd]),0) = 1" ).append("\n"); 
		query.append("then a.delt_flg	else 'N' end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}