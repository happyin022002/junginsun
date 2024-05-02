/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchBkgCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.11 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchBkgCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchBkgCngRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchBkgCngRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchBkgCngRSQL").append("\n"); 
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
		query.append("SELECT BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_A(@[bkg_no],@[corr_no]) RT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_B(@[bkg_no],@[corr_no]) CHG_TERM_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_C(@[bkg_no],@[corr_no]) RCVDE_TERM_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_D(@[bkg_no],@[corr_no]) ROUT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_E(@[bkg_no],@[corr_no]) CUST_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_F(@[bkg_no],@[corr_no]) QTY_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_G(@[bkg_no],@[corr_no]) MEAS_QTY_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_H(@[bkg_no],@[corr_no]) CMDT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_I(@[bkg_no],@[corr_no]) TRNK_VSL_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_J(@[bkg_no],@[corr_no]) PRPST_VSL_CORR_FLG" ).append("\n"); 
		query.append(", SUBSTR(BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_CLASS(@[bkg_no],@[corr_no]),1,1) RAT_FLG" ).append("\n"); 
		query.append(", SUBSTR(BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_CLASS(@[bkg_no],@[corr_no]),2,1) EXPN_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}