/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON-D/G CARGO의 KEYWORD 등록
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL").append("\n"); 
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
		query.append("SELECT non_dcgo_kw_seq, non_dcgo_kw_nm, non_dcgo_cate_grp_cd, delt_flg, delt_usr_id, delt_dt, cre_usr_id, cre_dt, cmt_ctnt," ).append("\n"); 
		query.append("       upd_usr_id, to_char(upd_dt,'yyyy-mm-dd') as upd_dt, kw_incl_flg" ).append("\n"); 
		query.append(" FROM  scg_non_dg_cgo_kw" ).append("\n"); 
		query.append("WHERE non_dcgo_cate_grp_cd LIKE @[non_dcgo_cate_cd]||'%'" ).append("\n"); 
		query.append("  AND non_dcgo_kw_nm LIKE @[non_dcgo_nm]||'%'" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 

	}
}