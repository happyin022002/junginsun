/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOaddBkgVvdFromPrdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.16 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOaddBkgVvdFromPrdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * prd 정보로 bkg_vvd에 insert한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOaddBkgVvdFromPrdCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tvvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOaddBkgVvdFromPrdCSQL").append("\n"); 
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
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append("insert into bkg_vvd_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("insert into bkg_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(bkg_no" ).append("\n"); 
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", corr_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", vsl_pre_pst_cd" ).append("\n"); 
		query.append(", vsl_seq" ).append("\n"); 
		query.append(", pol_cd" ).append("\n"); 
		query.append(", pol_yd_cd" ).append("\n"); 
		query.append(", pol_clpt_ind_seq" ).append("\n"); 
		query.append(", pod_cd" ).append("\n"); 
		query.append(", pod_yd_cd" ).append("\n"); 
		query.append(", pod_clpt_ind_seq" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", cre_usr_id" ).append("\n"); 
		query.append(", cre_dt" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", upd_dt)" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'S' vsl_pre_post_cd" ).append("\n"); 
		query.append(", rownum vsl_seq" ).append("\n"); 
		query.append(", substr(ORG_NOD_CD, 1, 5)  pol_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", substr(DEST_NOD_CD, 1, 5) pod_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq < ( select pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl, bkg_booking bk" ).append("\n"); 
		query.append("where dtl.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("and dtl.vsl_cd     = nvl(substr(@[tvvd], 1, 4), bk.vsl_cd)" ).append("\n"); 
		query.append("and dtl.skd_voy_no = nvl(substr(@[tvvd], 5, 4), bk.skd_voy_no)" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = nvl(substr(@[tvvd], 9, 1), bk.skd_dir_cd)" ).append("\n"); 
		query.append("AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS)" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no  = max_dwll.skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'T' vsl_pre_post_cd" ).append("\n"); 
		query.append(", 0 vsl_seq" ).append("\n"); 
		query.append(", substr(ORG_NOD_CD, 1, 5)  pol_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", substr(DEST_NOD_CD, 1, 5) pod_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq = ( select pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl, bkg_booking bk" ).append("\n"); 
		query.append("where dtl.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("and dtl.vsl_cd     = nvl(substr(@[tvvd], 1, 4), bk.vsl_cd)" ).append("\n"); 
		query.append("and dtl.skd_voy_no = nvl(substr(@[tvvd], 5, 4), bk.skd_voy_no)" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = nvl(substr(@[tvvd], 9, 1), bk.skd_dir_cd)" ).append("\n"); 
		query.append("AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS)" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no  = max_dwll.skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", 'U' vsl_pre_post_cd" ).append("\n"); 
		query.append(", rownum vsl_seq" ).append("\n"); 
		query.append(", substr(ORG_NOD_CD, 1, 5)  pol_cd" ).append("\n"); 
		query.append(", org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append(", ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append(", substr(DEST_NOD_CD, 1, 5) pod_cd" ).append("\n"); 
		query.append(", DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append(", DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append(", VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append(", VSL_CD                    vsl_cd" ).append("\n"); 
		query.append(", SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append(", decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and pctl_seq > ( select pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl, bkg_booking bk" ).append("\n"); 
		query.append("where dtl.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("and dtl.vsl_cd     = nvl(substr(@[tvvd], 1, 4), bk.vsl_cd)" ).append("\n"); 
		query.append("and dtl.skd_voy_no = nvl(substr(@[tvvd], 5, 4), bk.skd_voy_no)" ).append("\n"); 
		query.append("and dtl.skd_dir_cd = nvl(substr(@[tvvd], 9, 1), bk.skd_dir_cd)" ).append("\n"); 
		query.append("AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS)" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("and dtl.skd_voy_no  = max_dwll.skd_voy_no" ).append("\n"); 
		query.append("and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}