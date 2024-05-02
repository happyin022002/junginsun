/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOBkgBlNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.08 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOBkgBlNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02C search
	  * </pre>
	  */
	public TransferOrderIssueDBDAOBkgBlNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOBkgBlNoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("tro.io_bnd_cd," ).append("\n"); 
		query.append("cntr.cntr_no," ).append("\n"); 
		query.append("cntr.cntr_tpsz_cd," ).append("\n"); 
		query.append("cntr.cnmv_sts_cd," ).append("\n"); 
		query.append("cntr.adv_shtg_cd," ).append("\n"); 
		query.append("tro.curr_cd," ).append("\n"); 
		query.append("tro.trns_rev_amt," ).append("\n"); 
		query.append("tro.all_in_rt_cd," ).append("\n"); 
		query.append("tro.t1_doc_flg," ).append("\n"); 
		query.append("tro.vat_flg" ).append("\n"); 
		query.append("FROM bkg_eur_tro   tro," ).append("\n"); 
		query.append("bkg_container cntr" ).append("\n"); 
		query.append("WHERE cntr.bkg_no  = tro.bkg_no(+)" ).append("\n"); 
		query.append("AND cntr.cntr_no = tro.cntr_no(+)" ).append("\n"); 
		query.append("AND cntr.bkg_no  = @[bkg_no]" ).append("\n"); 
		query.append("AND 'N'			= TRO.CXL_FLG(+)" ).append("\n"); 
		query.append("AND NVL(@[io_bnd_cd], 'O') = tro.io_bnd_cd(+)" ).append("\n"); 

	}
}