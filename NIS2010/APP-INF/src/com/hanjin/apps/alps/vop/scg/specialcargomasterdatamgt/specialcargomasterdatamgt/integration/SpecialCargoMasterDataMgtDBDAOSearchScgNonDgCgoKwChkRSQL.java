/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchScgNonDgCgoKwChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchScgNonDgCgoKwChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON D/G CARGO 의 주의화물 KEYWORD 의 중복 데이터 입력을 막기 위함.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchScgNonDgCgoKwChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchScgNonDgCgoKwChkRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT FROM SCG_NON_DG_CGO_KW " ).append("\n"); 
		query.append("WHERE NON_DCGO_KW_NM =  @[non_dcgo_kw_nm]" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 

	}
}