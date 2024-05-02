/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchBkgListForCompFirmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.12.08 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOSearchBkgListForCompFirmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchBkgListForCompFirmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_post_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOSearchBkgListForCompFirmRSQL").append("\n"); 
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
		query.append("select 	  bk.bkg_no bkg_number" ).append("\n"); 
		query.append("        , bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd bkg_t_vvd" ).append("\n"); 
		query.append("        , bk.pol_cd pol_cd" ).append("\n"); 
		query.append("        , trim(sh.cust_nm) s_cust_nm" ).append("\n"); 
		query.append("        , trim(ff.cust_nm) f_cust_nm" ).append("\n"); 
		query.append("        , bk.rep_cmdt_cd cmdt_cd" ).append("\n"); 
		query.append("        , (select rep_cmdt_nm from mdm_rep_cmdt rep where rep.rep_cmdt_cd = bk.rep_cmdt_cd) cmdt_nm" ).append("\n"); 
		query.append("        , sum(decode(substr(qty.cntr_tpsz_cd, 2, 1), '2', qty.op_cntr_qty, 0)) feu" ).append("\n"); 
		query.append("        , sum(decode(substr(qty.cntr_tpsz_cd, 2, 1), '2', 0, qty.op_cntr_qty)) teu" ).append("\n"); 
		query.append("        , round(decode(bl.wgt_ut_cd, 'KGS', bl.act_wgt, bl.act_wgt * 0.45) / 1000) ton" ).append("\n"); 
		query.append("        , bk.pod_cd pod_cd" ).append("\n"); 
		query.append("		, bk.bkg_no" ).append("\n"); 
		query.append("        , bl.bdr_flg" ).append("\n"); 
		query.append("		, bk.bkg_sts_cd" ).append("\n"); 
		query.append("		,bk.BKG_WT_CHK_FLG" ).append("\n"); 
		query.append("    	,bk.EDI_HLD_FLG" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_customer sh" ).append("\n"); 
		query.append("        , bkg_customer ff" ).append("\n"); 
		query.append("        , bkg_quantity qty" ).append("\n"); 
		query.append("        , bkg_vvd vvd" ).append("\n"); 
		query.append("        , bkg_bl_doc bl" ).append("\n"); 
		query.append(" where bk.bkg_no       = sh.bkg_no" ).append("\n"); 
		query.append("   and sh.bkg_cust_tp_cd = 'S'" ).append("\n"); 
		query.append("   and bk.bkg_no       = ff.bkg_no" ).append("\n"); 
		query.append("   and ff.bkg_cust_tp_cd = 'F'" ).append("\n"); 
		query.append("   and bk.bkg_no       = qty.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no       = vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no       = bl.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_sts_cd   not in ('X', 'A', 'S')" ).append("\n"); 
		query.append("   and bk.bkg_cgo_tp_cd in ('F', 'R')" ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("   and bk.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${rep_cmdt} != '')    " ).append("\n"); 
		query.append("   and bk.rep_cmdt_cd  = @[rep_cmdt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_vvd_cd} != '')" ).append("\n"); 
		query.append("   and vvd.vsl_cd      = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   and vvd.skd_voy_no  = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   and vvd.skd_dir_cd  = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and vvd.vsl_pre_pst_cd = decode(@[vsl_pre_post_cd], 'T', 'T', '1', 'S')" ).append("\n"); 
		query.append("   and vvd.vsl_seq        = decode(@[vsl_pre_post_cd], 'T', '0', '1', '1')" ).append("\n"); 
		query.append("#if (${pol_cd} != '')   " ).append("\n"); 
		query.append("   and bk.pol_cd       = @[pol_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${pod_cd} != '')   " ).append("\n"); 
		query.append("   and bk.pod_cd       = @[pod_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')     " ).append("\n"); 
		query.append("   and bk.bkg_ofc_cd   = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')    " ).append("\n"); 
		query.append("   and bk.ob_sls_ofc_cd= @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${s_cust_cnt_cd} != '')    " ).append("\n"); 
		query.append("   and sh.cust_cnt_cd  = @[s_cust_cnt_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${s_cust_seq} != '')    " ).append("\n"); 
		query.append("   and sh.cust_seq     = @[s_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '' && ${bkg_sts_cd} != 'All')    " ).append("\n"); 
		query.append("   and bk.bkg_sts_cd   = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and bk.bkg_sts_cd   = 'W'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_nm} != '')    " ).append("\n"); 
		query.append("  #if(${s_cust_cnt_cd} == '' )" ).append("\n"); 
		query.append("     and UPPER(sh.cust_nm)      like '%'||UPPER(@[s_cust_nm])||'%'" ).append("\n"); 
		query.append("  #end   " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${f_cust_cnt_cd} != '')    " ).append("\n"); 
		query.append("   and ff.cust_cnt_cd  = @[f_cust_cnt_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${f_cust_seq} != '')    " ).append("\n"); 
		query.append("   and ff.cust_seq     = @[f_cust_seq]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${f_cust_nm} != '')   " ).append("\n"); 
		query.append("  #if(${f_cust_cnt_cd} == '') " ).append("\n"); 
		query.append("     and UPPER(ff.cust_nm)      like '%'||UPPER(@[f_cust_nm])||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${s_bkg_cre_dt} != '')    " ).append("\n"); 
		query.append("   and bk.bkg_cre_dt   > to_Date(@[s_bkg_cre_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if (${e_bkg_cre_dt} != '')    " ).append("\n"); 
		query.append("   and bk.bkg_cre_dt   < to_Date(@[e_bkg_cre_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("GROUP BY bk.bkg_no" ).append("\n"); 
		query.append("        , bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd" ).append("\n"); 
		query.append("        , bk.pol_cd" ).append("\n"); 
		query.append("        , sh.cust_nm" ).append("\n"); 
		query.append("        , ff.cust_nm" ).append("\n"); 
		query.append("        , bk.rep_cmdt_cd" ).append("\n"); 
		query.append("        , round(decode(bl.wgt_uT_cd, 'KGS', bl.act_wgt, bl.act_wgt * 0.45) / 1000)" ).append("\n"); 
		query.append("        , bk.pod_cd" ).append("\n"); 
		query.append("		, bk.bkg_no" ).append("\n"); 
		query.append("        , bl.bdr_flg" ).append("\n"); 
		query.append("		, bk.bkg_sts_cd" ).append("\n"); 
		query.append("		,bk.BKG_WT_CHK_FLG" ).append("\n"); 
		query.append("    	,bk.EDI_HLD_FLG" ).append("\n"); 

	}
}