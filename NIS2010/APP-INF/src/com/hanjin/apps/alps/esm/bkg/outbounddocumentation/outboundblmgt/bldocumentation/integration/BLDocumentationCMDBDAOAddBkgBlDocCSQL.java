/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOAddBkgBlDocCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.18 
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

public class BLDocumentationCMDBDAOAddBkgBlDocCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BL_DOC 저장
	  * </pre>
	  */
	public BLDocumentationCMDBDAOAddBkgBlDocCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mv_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOAddBkgBlDocCSQL").append("\n"); 
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
		query.append("        (bkg_no" ).append("\n"); 
		query.append("		, act_wgt" ).append("\n"); 
		query.append("		, act_wgt_prn_flg" ).append("\n"); 
		query.append("		, wgt_ut_cd" ).append("\n"); 
		query.append("        , MEAS_QTY" ).append("\n"); 
		query.append("        , MEAS_UT_CD" ).append("\n"); 
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
		query.append("        , cre_usr_id" ).append("\n"); 
		query.append("        , cre_dt" ).append("\n"); 
		query.append("        , upd_usr_id" ).append("\n"); 
		query.append("        , upd_dt)" ).append("\n"); 
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append("		, @[act_wgt]" ).append("\n"); 
		query.append("		, 'Y'" ).append("\n"); 
		query.append("		, @[wgt_ut_cd]" ).append("\n"); 
		query.append("        , 0" ).append("\n"); 
		query.append("        , NVL((SELECT MEAS_UT_CD FROM BKG_USR_DFLT_SET WHERE USR_ID = @[cre_usr_id]),'CBM') AS MEAS_UT_CD" ).append("\n"); 
		query.append("		, @[bl_mv_tp_nm]" ).append("\n"); 
		query.append("		, (select vsl_eng_nm||' '||bk.skd_voy_no ||bk.skd_dir_cd from mdm_vsl_cntr where vsl_cd = bk.vsl_cd) vsl_nm" ).append("\n"); 
		query.append("		, (select vsl_eng_nm||' '||vvd.skd_voy_no||vvd.skd_dir_cd" ).append("\n"); 
		query.append("		     from mdm_vsl_cntr vsl, bkg_vvd vvd " ).append("\n"); 
		query.append("		    where vsl.vsl_cd         = vvd.vsl_cd" ).append("\n"); 
		query.append("		      and vvd.vsl_pre_pst_cd = 'S'" ).append("\n"); 
		query.append("		      and vvd.vsl_seq        = '1'" ).append("\n"); 
		query.append("		      and vvd.bkg_no         = bk.bkg_no) pre_vsl_nm      " ).append("\n"); 
		query.append("		, bk.por_cd" ).append("\n"); 
		query.append("-- 기존에는 pod/del에 대해서만 YARD_NM_CONV 로직 적용 추후에 por/del에 대해서만 로직 2 적용" ).append("\n"); 
		query.append("        , NVL((SELECT ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'YARD_NM_CONV' AND ATTR_CTNT1 = BK.POR_NOD_CD AND ATTR_CTNT3 = '2')" ).append("\n"); 
		query.append("		  	 ,(select LOC_NM from mdm_location where loc_cd = bk.por_cd)) AS por_nm" ).append("\n"); 
		query.append("		, bk.pol_cd" ).append("\n"); 
		query.append("		, (select LOC_NM from mdm_location where loc_cd = bk.pol_cd) pol_nm" ).append("\n"); 
		query.append("		, bk.pod_cd" ).append("\n"); 
		query.append("		, NVL( (SELECT ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'YARD_NM_CONV' AND ATTR_CTNT1 = BK.POD_NOD_CD AND ATTR_CTNT3 = '1')" ).append("\n"); 
		query.append("		      ,(select LOC_NM from mdm_location where loc_cd = bk.pod_cd)) pod_nm" ).append("\n"); 
		query.append("		, bk.del_cd" ).append("\n"); 
		query.append("--		, decode(bk.rcv_term_cd, 'Y', nvl(del_nm.attr_ctnt2, del.loc_nm), del.loc_nm) del_nm" ).append("\n"); 
		query.append("-- NEW DELHI set 추가 Y term인 경우에 한해서	" ).append("\n"); 
		query.append("		, decode(bk.rcv_term_cd, 'Y', decode(NVL(bk.del_nod_cd, ' '), " ).append("\n"); 
		query.append("										'INDELY1', 'ICD TUGHLAKABAD,NEW DELHI'," ).append("\n"); 
		query.append("										'INDELY2', 'ICD PATPARGANJ, NEW DELHI'," ).append("\n"); 
		query.append("		  								NVL( (SELECT ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'YARD_NM_CONV' AND ATTR_CTNT1 = BK.DEL_NOD_CD)" ).append("\n"); 
		query.append("		  								    ,(select LOC_NM from mdm_location where loc_cd = bk.del_cd)))," ).append("\n"); 
		query.append("								 NVL( (SELECT ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'YARD_NM_CONV' AND ATTR_CTNT1 = BK.DEL_NOD_CD)" ).append("\n"); 
		query.append("		  						     ,(select LOC_NM from mdm_location where loc_cd = bk.del_cd))) AS DEL_NM" ).append("\n"); 
		query.append("		, nvl(@[fnl_dest_nm]," ).append("\n"); 
		query.append("          (select final_nm.attr_ctnt2" ).append("\n"); 
		query.append("		     from bkg_hrd_cdg_ctnt final_nm" ).append("\n"); 
		query.append("		    where bk.pod_cd         = final_nm.attr_ctnt1(+)" ).append("\n"); 
		query.append("		      and 'BL_FINAL_NAME'   = final_nm.hrd_cdg_id(+))) final_nm" ).append("\n"); 
		query.append("		, @[cre_usr_id]" ).append("\n"); 
		query.append("		, sysdate" ).append("\n"); 
		query.append("		, @[upd_usr_id]" ).append("\n"); 
		query.append("		, sysdate" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("		, mdm_location del" ).append("\n"); 
		query.append("		, bkg_hrd_cdg_ctnt del_nm" ).append("\n"); 
		query.append(" where bk.bkg_no        = @[bkg_no]" ).append("\n"); 
		query.append("   and bk.del_cd        = del.loc_cd	" ).append("\n"); 
		query.append("   and bk.del_cd||SUBSTR(bk.del_nod_cd, 6, 2) = del_nm.attr_ctnt1(+)" ).append("\n"); 
		query.append("   and 'BL_DEL_NAME'            = del_nm.hrd_cdg_id(+)" ).append("\n"); 

	}
}