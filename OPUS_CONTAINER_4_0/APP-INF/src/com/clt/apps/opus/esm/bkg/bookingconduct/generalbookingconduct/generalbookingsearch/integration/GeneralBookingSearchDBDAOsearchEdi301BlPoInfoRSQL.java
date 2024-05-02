/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchEdi301BlPoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.03 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchEdi301BlPoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301BlPoInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchEdi301BlPoInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchEdi301BlPoInfoRSQL").append("\n"); 
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
		query.append("SELECT	'{PO_INFO'											|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_BKG:'	   ||NVL(refDtl.BKG_NO,       ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_NO:'	   ||NVL(refDtl.PO_NO,		  ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_CNTR:'	   ||NVL(refDtl.CNTR_NO,      ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_SEQ:'	   ||NVL(refDtl.REF_SEQ,		0)		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_STOCK_NO:' ||NVL(refDtl.ITM_NO,       ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_DESC:'	   ||NVL(refDtl.ITM_DESC,     ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_PKGU:'	   ||NVL(refDtl.PCK_TP_CD,    ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_PKG_QTY:'  ||NVL(refDtl.PCK_QTY,        0)		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_WGTU:'	   ||NVL(refDtl.WGT_UT_CD,    ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_WGT:'	   ||NVL(refDtl.CNTR_WGT,       0)		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_MEAU:'	   ||NVL(refDtl.MEAS_UT_CD,   ' ')		|| CHR(10)" ).append("\n"); 
		query.append("	||	'PO_MEA:'	   ||NVL(refDtl.MEAS_QTY,       0)		|| CHR(10)" ).append("\n"); 
		query.append("	||	'}PO_INFO'											|| CHR(10) PO_INFO" ).append("\n"); 
		query.append("  FROM bkg_booking bk" ).append("\n"); 
		query.append("        , BKG_REF_DTL refDtl" ).append("\n"); 
		query.append(" WHERE bk.bkg_no  = refDtl.BKG_NO" ).append("\n"); 
		query.append("   and bk.bkg_no  = @[bkg_no]" ).append("\n"); 

	}
}