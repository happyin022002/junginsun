/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCopyBkgBlDocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCopyBkgBlDocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_bl_doc을 targetBkg로 복사한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCopyBkgBlDocCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCopyBkgBlDocCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_bl_doc" ).append("\n"); 
		query.append("        (bkg_no " ).append("\n"); 
		query.append("        , act_wgt " ).append("\n"); 
		query.append("        , wgt_ut_cd" ).append("\n"); 
		query.append("        , bl_mv_tp_NM" ).append("\n"); 
		query.append("        , vsl_nm" ).append("\n"); 
		query.append("        , pre_vsl_nm" ).append("\n"); 
		query.append("        , por_cd" ).append("\n"); 
		query.append("        , por_nm" ).append("\n"); 
		query.append("        , pol_cd" ).append("\n"); 
		query.append("        , pol_nm" ).append("\n"); 
		query.append("        , pod_cd" ).append("\n"); 
		query.append("        , pod_nm" ).append("\n"); 
		query.append("        , del_cd" ).append("\n"); 
		query.append("        , del_nm" ).append("\n"); 
		query.append("        , fnl_dest_nm" ).append("\n"); 
		query.append("	    , TTL_PCK_DESC" ).append("\n"); 
		query.append("        , cre_usr_id" ).append("\n"); 
		query.append("        , cre_dt" ).append("\n"); 
		query.append("        , upd_usr_id" ).append("\n"); 
		query.append("        , upd_dt)" ).append("\n"); 
		query.append("select   @[target_bkg_no]" ).append("\n"); 
		query.append("        , bl.act_wgt " ).append("\n"); 
		query.append("        , bl.wgt_ut_cd" ).append("\n"); 
		query.append("        , bl.bl_mv_tp_NM" ).append("\n"); 
		query.append("        , (select mdm.vsl_eng_nm || ' ' || bk.skd_voy_no || bk.skd_dir_cd from mdm_vsl_cntr mdm where mdm.vsl_cd = bk.vsl_cd)  vsl_nm" ).append("\n"); 
		query.append("        , (select mdm.vsl_eng_nm || ' ' || bk.skd_voy_no || bk.skd_dir_cd from mdm_vsl_cntr mdm where mdm.vsl_cd = vvd.vsl_cd) pre_vsl_nm" ).append("\n"); 
		query.append("        , bl.por_cd" ).append("\n"); 
		query.append("        , bl.por_nm" ).append("\n"); 
		query.append("        , bl.pol_cd" ).append("\n"); 
		query.append("        , bl.pol_nm" ).append("\n"); 
		query.append("        , bl.pod_cd" ).append("\n"); 
		query.append("        , bl.pod_nm" ).append("\n"); 
		query.append("        , bl.del_cd" ).append("\n"); 
		query.append("        , bl.del_nm" ).append("\n"); 
		query.append("        , bl.fnl_dest_nm" ).append("\n"); 
		query.append("	    , bl.TTL_PCK_DESC" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("  from bkg_bl_doc bl, bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append(" where bk.bkg_no = @[source_bkg_no]" ).append("\n"); 
		query.append("   and bk.bkg_no = bl.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no = vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and 'S'       = vvd.vsl_pre_pst_cd(+)" ).append("\n"); 
		query.append("   and 1         = vvd.vsl_seq(+)" ).append("\n"); 

	}
}