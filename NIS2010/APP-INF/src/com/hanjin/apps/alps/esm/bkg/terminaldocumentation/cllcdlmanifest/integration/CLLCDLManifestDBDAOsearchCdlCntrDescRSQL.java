/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlCntrDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.23 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlCntrDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlCntrDesc
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlCntrDescRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlCntrDescRSQL").append("\n"); 
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
		query.append("'D_CMDT:'||NVL(CMDT_HS_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'D_PUNIT:'||NVL(PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("'D_PKG:'||NVL(PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("'D_WGT:'||DECODE(NVL(WGT_UT_CD,' ')," ).append("\n"); 
		query.append("'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3)," ).append("\n"); 
		query.append("NVL(CNTR_MF_WGT,0)" ).append("\n"); 
		query.append(")||CHR(10)||" ).append("\n"); 
		query.append("'D_MEAS:'||DECODE(NVL(MEAS_UT_CD,' ')," ).append("\n"); 
		query.append("'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3)," ).append("\n"); 
		query.append("NVL(MEAS_QTY,0)" ).append("\n"); 
		query.append(")||CHR(10)||" ).append("\n"); 
		query.append("'D_HS_CD:'||NVL(HAMO_TRF_CD,' ')||CHR(10) CNTR_DESC," ).append("\n"); 
		query.append("'D_DESC:'||Translate(NVL(CNTR_MF_GDS_DESC,' '),chr(13)||chr(10),' ')||chr(10)||" ).append("\n"); 
		query.append("decode(CNTR_MF_MK_DESC," ).append("\n"); 
		query.append("NULL,''," ).append("\n"); 
		query.append("'{CUS_MARK'||chr(10)||'D_MARK:' ||" ).append("\n"); 
		query.append("replace(CNTR_MF_MK_DESC,chr(13)||chr(10),chr(10)||'D_MARK:')||chr(10)||" ).append("\n"); 
		query.append("'}CUS_MARK'||CHR(10)" ).append("\n"); 
		query.append(") CUS_MARK," ).append("\n"); 
		query.append("'}CNTR_DESC'||chr(10) CNTR_DESC_END" ).append("\n"); 
		query.append("FROM	BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE	BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO(+)    = @[cntr_no]" ).append("\n"); 

	}
}