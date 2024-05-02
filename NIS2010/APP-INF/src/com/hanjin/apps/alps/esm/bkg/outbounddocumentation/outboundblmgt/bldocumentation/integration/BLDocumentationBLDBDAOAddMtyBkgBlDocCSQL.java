/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOAddMtyBkgBlDocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOAddMtyBkgBlDocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking을 bkg_bl_doc에 insert한다
	  * </pre>
	  */
	public BLDocumentationBLDBDAOAddMtyBkgBlDocCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOAddMtyBkgBlDocCSQL").append("\n"); 
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
		query.append("(bkg_no" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(", BIS_SYS_FLG" ).append("\n"); 
		query.append(", BDR_CNG_FLG" ).append("\n"); 
		query.append(", BKG_CLZ_FLG" ).append("\n"); 
		query.append(", BKG_CLZ_CNG_FLG" ).append("\n"); 
		query.append(", BKG_CLZ_CNG_CFM_FLG" ).append("\n"); 
		query.append(", MK_DESC_CFM_FLG" ).append("\n"); 
		query.append(", act_wgt" ).append("\n"); 
		query.append(", wgt_ut_cd" ).append("\n"); 
		query.append(", vsl_nm" ).append("\n"); 
		query.append(", pre_vsl_nm" ).append("\n"); 
		query.append(", por_cd" ).append("\n"); 
		query.append(", por_nm" ).append("\n"); 
		query.append(", pol_cd" ).append("\n"); 
		query.append(", pol_nm" ).append("\n"); 
		query.append(", pod_cd" ).append("\n"); 
		query.append(", pod_nm" ).append("\n"); 
		query.append(", del_cd" ).append("\n"); 
		query.append(", del_nm" ).append("\n"); 
		query.append(", bdr_flg" ).append("\n"); 
		query.append(", bdr_dt" ).append("\n"); 
		query.append(", cre_usr_id" ).append("\n"); 
		query.append(", cre_dt" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", upd_dt)" ).append("\n"); 
		query.append("select    bk.bkg_no" ).append("\n"); 
		query.append(",'0'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(",'N'" ).append("\n"); 
		query.append(", 0   --act_wgt" ).append("\n"); 
		query.append(", 'KGS' --wgt_ut_cd" ).append("\n"); 
		query.append(", (select vsl_eng_nm from mdm_vsl_cntr where vsl_cd = bk.vsl_cd) vsl_nm" ).append("\n"); 
		query.append(", (select vsl_eng_nm" ).append("\n"); 
		query.append("from mdm_vsl_cntr vsl, bkg_vvd vvd" ).append("\n"); 
		query.append("where vsl.vsl_cd = vvd.vsl_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd = 'S'" ).append("\n"); 
		query.append("and vvd.vsl_seq = '1'" ).append("\n"); 
		query.append("and vvd.bkg_no = bk.bkg_no) pre_vsl_nm" ).append("\n"); 
		query.append(", bk.por_cd" ).append("\n"); 
		query.append(", (select LOC_NM from mdm_location where loc_cd = bk.por_cd) por_nm" ).append("\n"); 
		query.append(", bk.pol_cd" ).append("\n"); 
		query.append(", (select LOC_NM from mdm_location where loc_cd = bk.pol_cd) pol_nm" ).append("\n"); 
		query.append(", bk.pod_cd" ).append("\n"); 
		query.append(", (select LOC_NM from mdm_location where loc_cd = bk.pod_cd) pod_nm" ).append("\n"); 
		query.append(", bk.del_cd" ).append("\n"); 
		query.append(", (select LOC_NM from mdm_location where loc_cd = bk.del_cd) del_nm" ).append("\n"); 
		query.append(", 'Y'--bdr_flg" ).append("\n"); 
		query.append(", sysdate --bdr_dt" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}