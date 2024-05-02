/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CODCorrectionDBDAOaddAutoCodVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.24 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOaddAutoCodVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Creation, E-BKG/SI Upload 화면에서 Auto COD VVD를 insert한다
	  * </pre>
	  */
	public CODCorrectionDBDAOaddAutoCodVvdCSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOaddAutoCodVvdCSQL").append("\n"); 
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
		query.append("insert into bkg_cod_vvd" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(", COD_RQST_SEQ" ).append("\n"); 
		query.append(", VVD_OP_CD" ).append("\n"); 
		query.append(", VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", VSL_SEQ" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", POL_YD_CD" ).append("\n"); 
		query.append(", POD_YD_CD" ).append("\n"); 
		query.append(", POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select BKG_NO" ).append("\n"); 
		query.append("        , @[cod_rqst_seq]" ).append("\n"); 
		query.append("        , 'O' VVD_OP_CD" ).append("\n"); 
		query.append("        , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("        , VSL_SEQ" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , POL_YD_CD" ).append("\n"); 
		query.append("        , POD_YD_CD" ).append("\n"); 
		query.append("        , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("        , @[cod_rqst_seq]" ).append("\n"); 
		query.append("		, 'N' VVD_OP_CD" ).append("\n"); 
		query.append("        , 'S' vsl_pre_post_cd" ).append("\n"); 
		query.append("        , rownum vsl_seq" ).append("\n"); 
		query.append("        , VSL_CD                    vsl_cd" ).append("\n"); 
		query.append("        , SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append("        , decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append("        , VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append("        , org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append("        , DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append("        , ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append("        , DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("  from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(" where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("   and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("   AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("   and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("   and pctl_seq < ( select pctl_seq" ).append("\n"); 
		query.append("                      from prd_prod_ctl_rout_dtl dtl, bkg_booking bk, prd_prod_ctl_mst prd" ).append("\n"); 
		query.append("                     where prd.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("					   and prd.pctl_no 	  = dtl.pctl_no" ).append("\n"); 
		query.append("					   and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("                       and dtl.vsl_cd     = prd.trnk_vsl_cd" ).append("\n"); 
		query.append("                       and dtl.skd_voy_no = prd.trnk_skd_voy_no" ).append("\n"); 
		query.append("                       and dtl.skd_dir_cd = prd.trnk_skd_dir_cd" ).append("\n"); 
		query.append("					   AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS) " ).append("\n"); 
		query.append("            			                   		  from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("		                		                 where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("        		                	    	       and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("                		            		       and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("                        				           and dtl.skd_voy_no  = max_dwll.skd_voy_no " ).append("\n"); 
		query.append("                         	       		  		   and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append("					)                                " ).append("\n"); 
		query.append(" union" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("        , @[cod_rqst_seq]" ).append("\n"); 
		query.append("		, 'N' VVD_OP_CD" ).append("\n"); 
		query.append("        , 'T' vsl_pre_post_cd" ).append("\n"); 
		query.append("        , 0 vsl_seq" ).append("\n"); 
		query.append("        , VSL_CD                    vsl_cd" ).append("\n"); 
		query.append("        , SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append("        , decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append("        , VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append("        , org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append("        , DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append("        , ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append("        , DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("  from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(" where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("   and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("   AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("   and pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("   and pctl_seq = ( select pctl_seq" ).append("\n"); 
		query.append("                      from prd_prod_ctl_rout_dtl dtl, bkg_booking bk, prd_prod_ctl_mst prd" ).append("\n"); 
		query.append("                     where prd.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("					   and prd.pctl_no 	  = dtl.pctl_no" ).append("\n"); 
		query.append("					   and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("                       and dtl.vsl_cd     = prd.trnk_vsl_cd" ).append("\n"); 
		query.append("                       and dtl.skd_voy_no = prd.trnk_skd_voy_no" ).append("\n"); 
		query.append("                       and dtl.skd_dir_cd = prd.trnk_skd_dir_cd" ).append("\n"); 
		query.append("					   AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS) " ).append("\n"); 
		query.append("            			                   		  from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("		                		                 where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("        		                	    	       and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("                		            		       and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("                        				           and dtl.skd_voy_no  = max_dwll.skd_voy_no " ).append("\n"); 
		query.append("                         	       		  		   and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append("					)                                                         " ).append("\n"); 
		query.append(" union" ).append("\n"); 
		query.append("select @[bkg_no] bkg_no" ).append("\n"); 
		query.append("        , @[cod_rqst_seq]" ).append("\n"); 
		query.append("		, 'N' VVD_OP_CD" ).append("\n"); 
		query.append("        , 'U' vsl_pre_post_cd" ).append("\n"); 
		query.append("        , rownum vsl_seq" ).append("\n"); 
		query.append("        , VSL_CD                    vsl_cd" ).append("\n"); 
		query.append("        , SKD_VOY_NO                skd_voy_no" ).append("\n"); 
		query.append("        , decode(nvl(VSL_CD, 'X'), 'X', null, SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append("        , VSL_SLAN_CD               slan_cd" ).append("\n"); 
		query.append("        , org_nod_cd                pol_yd_cd" ).append("\n"); 
		query.append("        , DEST_NOD_CD               pod_yd_cd" ).append("\n"); 
		query.append("        , ORG_CLPT_IND_SEQ          pol_clpt_ind_seq" ).append("\n"); 
		query.append("        , DEST_CLPT_IND_SEQ         pod_clpt_ind_seq" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("  from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append(" where TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("   and PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("   AND SUBSTR(ORG_NOD_CD, 1, 5) <> SUBSTR(DEST_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("   and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("   and pctl_seq > ( select pctl_seq" ).append("\n"); 
		query.append("                      from prd_prod_ctl_rout_dtl dtl, bkg_booking bk, prd_prod_ctl_mst prd" ).append("\n"); 
		query.append("                     where prd.pctl_no    = @[pctl_no]" ).append("\n"); 
		query.append("					   and prd.pctl_no 	  = dtl.pctl_no" ).append("\n"); 
		query.append("					   and bk.bkg_no      = @[bkg_no]" ).append("\n"); 
		query.append("                       and dtl.vsl_cd     = prd.trnk_vsl_cd" ).append("\n"); 
		query.append("                       and dtl.skd_voy_no = prd.trnk_skd_voy_no" ).append("\n"); 
		query.append("                       and dtl.skd_dir_cd = prd.trnk_skd_dir_cd" ).append("\n"); 
		query.append("					   AND dtl.TZ_DWLL_TM_HRS = (select max(TZ_DWLL_TM_HRS) " ).append("\n"); 
		query.append("            			                   		  from prd_prod_ctl_rout_dtl max_dwll" ).append("\n"); 
		query.append("		                		                 where max_dwll.pctl_no  = @[pctl_no]" ).append("\n"); 
		query.append("        		                	    	       and dtl.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("                		            		       and dtl.vsl_cd      = max_dwll.vsl_cd" ).append("\n"); 
		query.append("                        				           and dtl.skd_voy_no  = max_dwll.skd_voy_no " ).append("\n"); 
		query.append("                         	       		  		   and dtl.skd_dir_cd  = max_dwll.skd_dir_cd)" ).append("\n"); 
		query.append("					)" ).append("\n"); 

	}
}