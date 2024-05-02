/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearch315MasterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearch315MasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search315MasterList
	  * </pre>
	  */
	public Edi315SendDBDAOSearch315MasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearch315MasterListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("h.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("h.COP_RAIL_CHK_CD," ).append("\n"); 
		query.append("h.TRNK_VSL_CD||h.TRNK_SKD_VOY_NO||h.TRNK_SKD_DIR_CD trunk_vvd," ).append("\n"); 
		query.append("h.cop_sts_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("b.POR_NOD_CD," ).append("\n"); 
		query.append("b.POL_NOD_CD," ).append("\n"); 
		query.append("b.POD_NOD_CD," ).append("\n"); 
		query.append("b.DEL_NOD_CD," ).append("\n"); 
		query.append("b.POR_CD," ).append("\n"); 
		query.append("b.POL_CD," ).append("\n"); 
		query.append("b.POD_CD," ).append("\n"); 
		query.append("b.DEL_CD," ).append("\n"); 
		query.append("b.sc_no," ).append("\n"); 
		query.append("b.bl_tp_cd," ).append("\n"); 
		query.append("b.VSL_CD           		to_vsl," ).append("\n"); 
		query.append("b.SKD_VOY_NO 			to_voyage," ).append("\n"); 
		query.append("b.SKD_DIR_CD 			to_dir," ).append("\n"); 
		query.append("b.PRE_RLY_PORT_CD 		pre_rly," ).append("\n"); 
		query.append("b.PST_RLY_PORT_CD 		post_rly," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("b.BKG_CRE_TP_CD," ).append("\n"); 
		query.append("b.RCV_TERM_CD," ).append("\n"); 
		query.append("b.DE_TERM_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("nvl(b.DCGO_FLG,'N') dcgo_flg, -- HP 추가 요건 : yjlee 20100608" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("org.CONTI_CD org_conti," ).append("\n"); 
		query.append("dest.CONTI_CD dest_conti," ).append("\n"); 
		query.append("replace(mv.vsl_eng_nm, chr(39), ' ') vsl_nm ," ).append("\n"); 
		query.append("mv.vsl_rgst_cnt_cd                   vsl_cnt_cd," ).append("\n"); 
		query.append("nvl(decode(mv.LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', LLOYD_NO), ' ')  lloyd_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from sce_cop_hdr h, bkg_booking b, mdm_location org, mdm_location dest , MDM_VSL_CNTR MV" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and h.cop_no = @[e_cop_no]" ).append("\n"); 
		query.append("and h.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and org.loc_cd  = substr(h.por_nod_cd,1,5)" ).append("\n"); 
		query.append("and dest.loc_cd = substr(h.del_nod_cd,1,5)" ).append("\n"); 
		query.append("and MV.VSL_CD(+) = B.VSL_CD" ).append("\n"); 

	}
}