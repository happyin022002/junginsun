/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchBkgCodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.11.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchBkgCodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod을 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchBkgCodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchBkgCodRSQL").append("\n"); 
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
		query.append("#if(${pctl_no}=='')" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append("        , bk.bl_no" ).append("\n"); 
		query.append("        , bk.bl_tp_cd" ).append("\n"); 
		query.append("        , cod.cod_sts_cd        cod_status" ).append("\n"); 
		query.append("        , nvl(cod.cod_rqst_seq, nvl(@[codRqstSeq], 1)) seq" ).append("\n"); 
		query.append("		, (select max(cod_rqst_seq) from bkg_cod seq where seq.bkg_no = cod.bkg_no) max_seq" ).append("\n"); 
		query.append("		, cod.auto_cod_flg 		auto_cod_flg" ).append("\n"); 
		query.append("        , cod.cod_auth_flg      arrpoval" ).append("\n"); 
		query.append("        , rgn_cd                approval_rso" ).append("\n"); 
		query.append("        , cod.cod_rqst_rsn_cd   cod_reason" ).append("\n"); 
		query.append("        , diff_rmk              cod_remark" ).append("\n"); 
		query.append("        , cod.cod_rhnd_port_cd||substr(cod.cod_rhnd_port_yd_cd, 6, 2) rehandling_port" ).append("\n"); 
		query.append("        , cod.cod_rjct_cd       reject_reason_code" ).append("\n"); 
		query.append("        , cod.cod_rjct_rsn_rmk  reject_reason_remark" ).append("\n"); 
		query.append("		, cod.cod_mnl_flg " ).append("\n"); 
		query.append("        , cod.pctl_no " ).append("\n"); 
		query.append("        , nvl(substr(cod.old_por_yd_cd, 1, 5), bk.por_cd)                   old_por_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_por_yd_cd, 6, 2), substr(bk.por_nod_cd, 6, 2)) old_por_nod_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_pol_yd_cd, 1, 5), bk.pol_cd)                   old_pol_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_pol_yd_cd, 6, 2), substr(bk.pol_nod_cd, 6, 2)) old_pol_nod_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_pod_yd_cd, 1, 5), bk.pod_cd)                   old_pod_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_pod_yd_cd, 6, 2), substr(bk.pod_nod_cd, 6, 2)) old_pod_nod_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_del_yd_cd, 1, 5), bk.del_cd)                   old_del_cd" ).append("\n"); 
		query.append("        , nvl(substr(cod.old_del_yd_cd, 6, 2), substr(bk.del_nod_cd, 6, 2)) old_del_nod_cd" ).append("\n"); 
		query.append("		, nvl(cod.old_de_term_cd, bk.de_term_cd) old_de_term_cd" ).append("\n"); 
		query.append("		, case when cod.old_pol_yd_cd is null             then substr(bk.pre_rly_port_cd, 1, 5) --bkg_cod 생성 전 bkg의  relay port" ).append("\n"); 
		query.append("		       when cod.old_pol_yd_cd = old_VVD.POL_YD_CD then null								--t/s 없는 경우" ).append("\n"); 
		query.append("		       else substr(old_VVD.POL_YD_CD, 1, 5) end old_pre_cd								--trunk의 loading " ).append("\n"); 
		query.append("		, case when cod.old_pol_yd_cd is null             then substr(bk.pre_rly_port_cd, 6, 2)" ).append("\n"); 
		query.append("		       when cod.old_pol_yd_cd = old_VVD.POL_YD_CD then null" ).append("\n"); 
		query.append("		       else substr(old_VVD.POL_YD_CD, 6, 2) end old_pre_nod_cd" ).append("\n"); 
		query.append("		, case when cod.old_pod_yd_cd is null             then substr(bk.pst_rly_port_cd, 1, 5)" ).append("\n"); 
		query.append("		       when cod.old_pod_yd_cd = old_VVD.POd_YD_CD then null" ).append("\n"); 
		query.append("		       else substr(old_VVD.POd_YD_CD, 1, 5) end old_pst_cd" ).append("\n"); 
		query.append("		, case when cod.old_pod_yd_cd is null             then substr(bk.pst_rly_port_cd, 6, 2)" ).append("\n"); 
		query.append("		       when cod.old_pod_yd_cd = old_VVD.Pod_YD_CD then null" ).append("\n"); 
		query.append("		       else substr(old_VVD.POd_YD_CD, 6, 2) end old_pst_nod_cd" ).append("\n"); 
		query.append("        , nvl(cod.old_vsl_cd||cod.old_skd_voy_no||cod.old_skd_dir_cd, bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd) old_tvvd" ).append("\n"); 
		query.append("        , substr(cod.new_por_yd_cd, 1, 5) new_por_cd" ).append("\n"); 
		query.append("        , substr(cod.new_por_yd_cd, 6, 2) new_por_nod_cd" ).append("\n"); 
		query.append("        , substr(cod.new_pol_yd_cd, 1, 5) new_pol_cd" ).append("\n"); 
		query.append("        , substr(cod.new_pol_yd_cd, 6, 2) new_pol_nod_cd" ).append("\n"); 
		query.append("        , substr(cod.new_pod_yd_cd, 1, 5) new_pod_cd" ).append("\n"); 
		query.append("        , substr(cod.new_pod_yd_cd, 6, 2) new_pod_nod_cd" ).append("\n"); 
		query.append("        , substr(cod.new_del_yd_cd, 1, 5) new_del_cd" ).append("\n"); 
		query.append("        , substr(cod.new_del_yd_cd, 6, 2) new_del_nod_cd" ).append("\n"); 
		query.append("		, cod.new_de_term_cd" ).append("\n"); 
		query.append("		, substr(DECODE(cod.new_pol_yd_cd, NEW_VVD.POL_YD_CD, NULL, NEW_VVD.POL_YD_CD), 1, 5) new_pre_cd" ).append("\n"); 
		query.append("		, substr(DECODE(cod.new_pol_yd_cd, NEW_VVD.POL_YD_CD, NULL, NEW_VVD.POL_YD_CD), 6, 2) new_pre_nod_cd" ).append("\n"); 
		query.append("		, substr(DECODE(cod.new_poD_yd_cd, NEW_VVD.POD_YD_CD, NULL, NEW_VVD.POD_YD_CD), 1, 5) new_pst_cd" ).append("\n"); 
		query.append("		, substr(DECODE(cod.new_poD_yd_cd, NEW_VVD.POD_YD_CD, NULL, NEW_VVD.POD_YD_CD), 6, 2) new_pst_nod_cd" ).append("\n"); 
		query.append("        , cod.new_vsl_cd||cod.new_skd_voy_no||cod.new_skd_dir_cd    new_tvvd" ).append("\n"); 
		query.append("        , bk.bkg_sts_cd " ).append("\n"); 
		query.append("        , bl.bdr_flg" ).append("\n"); 
		query.append("        , nvl((select '1'" ).append("\n"); 
		query.append("                 from bkg_cod pre_cod" ).append("\n"); 
		query.append("                where cod.bkg_no         = pre_cod.bkg_no" ).append("\n"); 
		query.append("                  and cod.cod_rqst_seq   > pre_cod.cod_rqst_seq " ).append("\n"); 
		query.append("                  and pre_cod.cod_sts_cd in ('R', 'W', 'Y')" ).append("\n"); 
		query.append("                  and rownum             = 1" ).append("\n"); 
		query.append("              ), '0') cannot_confirm_flg         " ).append("\n"); 
		query.append("  from bkg_cod cod" ).append("\n"); 
		query.append("        , bkg_cod_vvd new_vvd" ).append("\n"); 
		query.append("        , bkg_cod_vvd old_vvd" ).append("\n"); 
		query.append("        , bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_bl_doc bl" ).append("\n"); 
		query.append(" where bk.bkg_no = bl.bkg_no " ).append("\n"); 
		query.append(" and bk.bkg_no   = cod.bkg_no(+)" ).append("\n"); 
		query.append("	#if(${codRqstSeq} !='')" ).append("\n"); 
		query.append("	   and @[codRqstSeq] = cod.cod_rqst_seq(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	   and bk.bkg_no   = new_vvd.bkg_no(+)" ).append("\n"); 
		query.append("	#if(${codRqstSeq} !='')" ).append("\n"); 
		query.append("	   and @[codRqstSeq] = new_vvd.cod_rqst_seq(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	   and 'N'         = new_vvd.vvd_op_cd(+) " ).append("\n"); 
		query.append("	   and 'T'         = new_vvd.vsl_pre_pst_cd(+)" ).append("\n"); 
		query.append("	   and bk.bkg_no   = old_vvd.bkg_no(+)" ).append("\n"); 
		query.append("	#if(${codRqstSeq} !='')" ).append("\n"); 
		query.append("	   and @[codRqstSeq] = old_vvd.cod_rqst_seq(+)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	   and 'O'         = old_vvd.vvd_op_cd(+)" ).append("\n"); 
		query.append("	   and 'T'         = old_vvd.vsl_pre_pst_cd(+)" ).append("\n"); 
		query.append("	#if(${bkgNo} !='')" ).append("\n"); 
		query.append("	   and bk.bkg_no   = @[bkgNo]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	select    substr(mst.pod_nod_cd, 1, 5) new_pod_cd" ).append("\n"); 
		query.append("	        , substr(mst.pod_nod_cd, 6, 2) new_pod_nod_cd" ).append("\n"); 
		query.append("	        , substr(mst.del_nod_cd, 1, 5) new_del_cd" ).append("\n"); 
		query.append("	        , substr(mst.del_nod_cd, 6, 2) new_del_nod_cd" ).append("\n"); 
		query.append("			, mst.bkg_de_term_cd new_de_term_cd" ).append("\n"); 
		query.append("			, decode(mst.pol_nod_cd, trunk.ORG_NOD_CD,  '', SUBSTR(trunk.ORG_NOD_CD,  1, 5)) new_pre_cd" ).append("\n"); 
		query.append("			, decode(mst.pol_nod_cd, trunk.ORG_NOD_CD,  '', SUBSTR(trunk.ORG_NOD_CD,  6, 2)) new_pre_nod_cd" ).append("\n"); 
		query.append("			, decode(mst.pod_nod_cd, trunk.DEST_NOD_CD, '', SUBSTR(trunk.DEST_NOD_CD, 1, 5)) new_pst_cd" ).append("\n"); 
		query.append("			, decode(mst.pod_nod_cd, trunk.DEST_NOD_CD, '', SUBSTR(trunk.DEST_NOD_CD, 6, 2)) new_pst_nod_cd" ).append("\n"); 
		query.append("	        , trnk_vsl_cd||trnk_skd_voy_no||trnk_skd_dir_cd    new_tvvd" ).append("\n"); 
		query.append("	  from prd_prod_ctl_mst  mst" ).append("\n"); 
		query.append("	   	  , prd_prod_ctl_rout_dtl trunk" ).append("\n"); 
		query.append("	 where mst.pctl_no       = trunk.pctl_no" ).append("\n"); 
		query.append("	   and trunk.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("	   and trunk.vsl_cd      = mst.trnk_vsl_cd" ).append("\n"); 
		query.append("	   and trunk.skd_voy_no  = mst.trnk_skd_voy_no " ).append("\n"); 
		query.append("	   and trunk.skd_dir_cd  = mst.trnk_skd_dir_cd" ).append("\n"); 
		query.append("	   and mst.pctl_no       = @[pctl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}