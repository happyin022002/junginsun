/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEmptyCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEmptyCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg의 origin location이 POL인 bkg VVD로 movement data를 검색하여 
	  * 1. Empty이고 Status가 VL, 
	  * 2. Bkg No. 미 mapping
	  * 3. Movement의 VVD가 같거나 Bkg VVD의 call sign / Lloyd code (vessel table에서 검색)과 같은 것(Manual로 update된 movement 포함)
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEmptyCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEmptyCntrRSQL").append("\n"); 
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
		query.append("select substr(bkg.cntr_no,1,10) cntr_no, " ).append("\n"); 
		query.append("	substr(bkg.cntr_no,11,1) cntr_no_PST," ).append("\n"); 
		query.append("    bkg.cntr_no full_cntr_no," ).append("\n"); 
		query.append("	bkg.cntr_tpsz_cd TPSZ_CD,      " ).append("\n"); 
		query.append("  	bkg.cnmv_sts_cd STS_CD," ).append("\n"); 
		query.append("  	bkg.mcntr_bdl_no BDL_NO," ).append("\n"); 
		query.append("  	'' POD_CD," ).append("\n"); 
		query.append("  	ctm.pre_sts_flg," ).append("\n"); 
		query.append("  	bkg.bdl_btm_flg," ).append("\n"); 
		query.append("  	(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("    	 FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("	    WHERE INTG_CD_ID = 'CD02012'" ).append("\n"); 
		query.append("    	  AND INTG_CD_VAL_CTNT = ctm.CNTR_HNGR_RCK_CD) CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("	ctm.mnr_hngr_bar_tp_cd," ).append("\n"); 
		query.append("	ctm.cntr_hngr_bar_atch_knt" ).append("\n"); 
		query.append("from  bkg_container bkg, mst_container ctm" ).append("\n"); 
		query.append("where   BKG.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and     bkg.cntr_no = ctm.cntr_no" ).append("\n"); 

	}
}