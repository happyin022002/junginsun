/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcopyBkgCntcPsonByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcopyBkgCntcPsonByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sourceBkg의 bkg_cntc_pson를 targetBkg로 복사한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcopyBkgCntcPsonByBkgCSQL(){
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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcopyBkgCntcPsonByBkgCSQL").append("\n"); 
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
		query.append("insert into BKG_CNTC_PSON" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append(",CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PSON_EML" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(",BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",CNTC_PSON_MPHN_NO" ).append("\n"); 
		query.append(",CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",CNTC_PSON_EML" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(",sysdate CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(",sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_cntc_pson" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}