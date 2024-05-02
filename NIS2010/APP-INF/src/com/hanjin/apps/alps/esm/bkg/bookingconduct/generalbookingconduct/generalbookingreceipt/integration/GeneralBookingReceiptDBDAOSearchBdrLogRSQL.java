/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBdrLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBdrLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 route의 bdr 여부를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBdrLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBdrLogRSQL").append("\n"); 
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
		query.append("SELECT route.vsl_cd||route.skd_voy_no||route.skd_dir_cd BDR_VVD" ).append("\n"); 
		query.append("FROM BKG_VVD_BDR_LOG bdr" ).append("\n"); 
		query.append(", (select VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append(", substr(ORG_NOD_CD, 1, 5)  pol" ).append("\n"); 
		query.append(", substr(DEST_NOD_CD, 1, 5) pod" ).append("\n"); 
		query.append(", nvl((select 'Y'" ).append("\n"); 
		query.append("from prd_prod_ctl_mst trunk" ).append("\n"); 
		query.append("where trunk.pctl_no         = route.pctl_no" ).append("\n"); 
		query.append("and trunk.trnk_VSL_CD     = route.vsl_cd" ).append("\n"); 
		query.append("AND trunk.trnk_SKD_VOY_NO = route.skd_voy_no" ).append("\n"); 
		query.append("AND trunk.trnk_SKD_DIR_CD = route.skd_dir_cd), 'N') trnk_flg" ).append("\n"); 
		query.append(", org_clpt_ind_seq" ).append("\n"); 
		query.append(", dest_clpt_ind_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl route" ).append("\n"); 
		query.append("where PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("and TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("and pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("order by pctl_seq) route" ).append("\n"); 
		query.append("WHERE bdr.VSL_CD     = route.vsl_cd" ).append("\n"); 
		query.append("AND bdr.SKD_VOY_NO = route.skd_voy_no" ).append("\n"); 
		query.append("AND bdr.SKD_DIR_CD = route.skd_dir_cd" ).append("\n"); 
		query.append("AND bdr.POL_CD     = route.pol" ).append("\n"); 
		query.append("AND bdr.POD_CD     = NVL(route.pod, POD_CD)" ).append("\n"); 
		query.append("and bdr.pol_clpt_ind_seq = route.org_clpt_ind_seq" ).append("\n"); 
		query.append("and bdr.pod_clpt_ind_seq = route.dest_clpt_ind_seq" ).append("\n"); 
		query.append("and ((trnk_flg = 'Y' and (TRNK_AUTO_BDR_FLG = 'Y' or TRNK_MNL_BDR_FLG = 'Y' or TRNK_BDR_FLG = 'Y'))" ).append("\n"); 
		query.append("or" ).append("\n"); 
		query.append("(trnk_flg = 'N' and (FDR_AUTO_BDR_FLG  = 'Y' or FDR_MNL_BDR_FLG  = 'Y' or FDR_BDR_FLG  = 'Y')))" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}