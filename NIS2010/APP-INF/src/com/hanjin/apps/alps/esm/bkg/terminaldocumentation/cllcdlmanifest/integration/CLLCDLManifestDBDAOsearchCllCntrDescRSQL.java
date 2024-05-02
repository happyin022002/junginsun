/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCntrDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCntrDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCntrDesc
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCntrDescRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCntrDescRSQL").append("\n"); 
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
		query.append("SELECT	'{CNTR_DESC'||CHR(10)||" ).append("\n"); 
		query.append("	'D_CMDT:'||NVL(BK.CMDT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'D_PUNIT:'||NVL(MF.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'D_PKG:'||NVL(MF.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'D_WGT:'||DECODE(NVL(MF.WGT_UT_CD,' ')," ).append("\n"); 
		query.append("					 'LBS', ROUND(NVL(MF.CNTR_MF_WGT,0)*0.4536,3)," ).append("\n"); 
		query.append("					 NVL(MF.CNTR_MF_WGT,0))||CHR(10)||" ).append("\n"); 
		query.append("	'D_MEAS:'||DECODE(NVL(MF.MEAS_UT_CD,' ')," ).append("\n"); 
		query.append("					  'CBF', ROUND(NVL(MF.MEAS_QTY,0)*0.0283,3)," ).append("\n"); 
		query.append("					  NVL(MF.MEAS_QTY,0))||CHR(10)||" ).append("\n"); 
		query.append("	'D_HS_CD:'||NVL(MF.CMDT_HS_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'D_HTS_CD:'||NVL(MF.HAMO_TRF_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'D_NCM_CD:'||NVL(MF.NCM_NO,' ')||CHR(10) CNTR_DESC," ).append("\n"); 
		query.append("	'D_DESC:'||Translate(NVL(MF.CNTR_MF_GDS_DESC,' '),chr(13)||chr(10),' ')||chr(10)||" ).append("\n"); 
		query.append("    DECODE(MF.CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("           NULL, TO_CLOB('')," ).append("\n"); 
		query.append("           TO_CLOB('{CUS_MARK')||chr(10)||'D_MARK:' ||replace(MF.CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("                                                     chr(13)||chr(10)," ).append("\n"); 
		query.append("                                                     chr(10)||'D_MARK:')||" ).append("\n"); 
		query.append("                                             chr(10)||'}CUS_MARK'||CHR(10)) CUS_MARK," ).append("\n"); 
		query.append("	'}CNTR_DESC'||chr(10) CNTR_DESC_END" ).append("\n"); 
		query.append("FROM	BKG_CNTR_MF_DESC MF, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE	BK.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("AND	MF.CNTR_NO(+)		= @[cntr_no]" ).append("\n"); 

	}
}