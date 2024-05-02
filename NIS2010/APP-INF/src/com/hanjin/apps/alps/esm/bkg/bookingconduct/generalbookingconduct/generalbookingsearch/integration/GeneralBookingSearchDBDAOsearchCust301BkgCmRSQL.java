/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301BkgCm
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301BkgCmRSQL").append("\n"); 
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
		query.append("SELECT '{CM_MARK_DESC'                             ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_SEQ:'     ||CNTR_MF_SEQ               ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_CNTR_NO:' ||NVL(CNTR_NO, '')          ||CHR(10)||        " ).append("\n"); 
		query.append("        'CMD_HTS_CD:'  ||NVL(HAMO_TRF_CD, '')      ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_PKG_CD:'  ||NVL(PCK_TP_CD, '')        ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_PKG_QTY:' ||NVL(Pck_QTY, 0)           ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_WGT_TP:'  ||NVL(WGT_ut_cd, '')        ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_WGT_QTY:' ||NVL(Cntr_mf_WGT, 0)       ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MEA_TP:'  ||NVL(MEAs_ut_cd, '')       ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MEA_QTY:' ||NVL(MEAs_QTY, 0)          ||CHR(10)||" ).append("\n"); 
		query.append("		'CMD_DESC:'    ||NVL(CNTR_MF_GDS_DESC, '') ||CHR(10)||" ).append("\n"); 
		query.append("        'CMD_MARK:'    ||REPLACE(NVL(CNTR_MF_MK_DESC, ' '),CHR(13)||CHR(10),' ') ||CHR(10)||" ).append("\n"); 
		query.append("        '}CM_MARK_DESC'                            ||CHR(10) CM_MARK_DESC" ).append("\n"); 
		query.append("  FROM bkg_cntr_mf_desc" ).append("\n"); 
		query.append(" WHERE bkg_no   = @[bkg_no]" ).append("\n"); 
		query.append(" ORDER BY CNTR_MF_SEQ" ).append("\n"); 

	}
}