/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON D/G CARGO 의 주의화물 KEYWORD 중복 입력을 체크하기 위함
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL").append("\n"); 
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
		query.append("WHERE NON_DCGO_KW_NM = @[non_dcgo_kw_nm]" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 

	}
}