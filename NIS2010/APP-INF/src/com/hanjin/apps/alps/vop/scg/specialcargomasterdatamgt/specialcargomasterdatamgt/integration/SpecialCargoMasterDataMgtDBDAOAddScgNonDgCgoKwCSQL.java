/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NON D/G CARGO 의 주의화물 KEYWORD 등록하기 위함.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dcgo_cate_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kw_incl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_dcgo_kw_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL").append("\n"); 
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
		query.append("INSERT INTO scg_non_dg_cgo_kw " ).append("\n"); 
		query.append("       (  non_dcgo_kw_seq, " ).append("\n"); 
		query.append("          non_dcgo_kw_nm, " ).append("\n"); 
		query.append("          non_dcgo_cate_grp_cd, " ).append("\n"); 
		query.append("          delt_flg, " ).append("\n"); 
		query.append("          cmt_ctnt," ).append("\n"); 
		query.append("          cre_usr_id, " ).append("\n"); 
		query.append("          cre_dt, " ).append("\n"); 
		query.append("          upd_usr_id, " ).append("\n"); 
		query.append("          upd_dt," ).append("\n"); 
		query.append("          kw_incl_flg)" ).append("\n"); 
		query.append(" SELECT   MAX(non_dcgo_kw_seq)+1 , " ).append("\n"); 
		query.append("          upper(@[non_dcgo_kw_nm]), " ).append("\n"); 
		query.append("          @[non_dcgo_cate_grp_cd], " ).append("\n"); 
		query.append("          'N', " ).append("\n"); 
		query.append("          @[cmt_ctnt]," ).append("\n"); 
		query.append("          @[cre_usr_id], " ).append("\n"); 
		query.append("          SYSDATE, " ).append("\n"); 
		query.append("          @[upd_usr_id], " ).append("\n"); 
		query.append("          SYSDATE," ).append("\n"); 
		query.append("          DECODE(@[kw_incl_flg],'1','Y','0','','')" ).append("\n"); 
		query.append("   FROM scg_non_dg_cgo_kw" ).append("\n"); 

	}
}