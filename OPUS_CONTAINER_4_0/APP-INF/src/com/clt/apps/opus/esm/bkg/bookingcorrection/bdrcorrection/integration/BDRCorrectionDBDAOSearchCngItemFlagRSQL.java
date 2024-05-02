/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCngItemFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.12.01 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCngItemFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCngItemFlagRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCngItemFlagRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration ").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCngItemFlagRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_CLASS(@[bkg_no], 'TMP0000001'), 1,1) RAT_FLG" ).append("\n"); 
		query.append(", SUBSTR(BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_CLASS(@[bkg_no], 'TMP0000001'), 2,1) EXPN_FLG" ).append("\n"); 
		query.append(", '' DOC_PERF_EXPT_CD" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_A(@[bkg_no], 'TMP0000001') RT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_B(@[bkg_no], 'TMP0000001') CHG_TERM_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_C(@[bkg_no], 'TMP0000001') RCVDE_TERM_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_D(@[bkg_no], 'TMP0000001') ROUT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_E(@[bkg_no], 'TMP0000001') CUST_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_F(@[bkg_no], 'TMP0000001') QTY_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_G(@[bkg_no], 'TMP0000001') MEAS_QTY_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_H(@[bkg_no], 'TMP0000001') CMDT_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_I(@[bkg_no], 'TMP0000001') TRNK_VSL_CORR_FLG" ).append("\n"); 
		query.append(", BKG_CORR_KIND_PKG.BKG_CORR_KIND_PKG_J(@[bkg_no], 'TMP0000001') PRPST_VSL_CORR_FLG" ).append("\n"); 
		query.append("FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 

	}
}