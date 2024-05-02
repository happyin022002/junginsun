/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export EDI 전송시 Container Description정보를 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrDescRSQL").append("\n"); 
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
		query.append("SELECT 	NVL(CMDT_HS_CD,' ') D_CMDT," ).append("\n"); 
		query.append("	   	NVL(PCK_TP_CD,' ') D_PUNIT," ).append("\n"); 
		query.append("	   	NVL(PCK_QTY,'') D_PKG," ).append("\n"); 
		query.append("	   	DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,'')*0.4536,3),NVL(CNTR_MF_WGT,'')) D_WGT," ).append("\n"); 
		query.append("	   	DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,'')*0.0283,3),NVL(MEAS_QTY,'')) D_MEAS," ).append("\n"); 
		query.append("	   	Translate(NVL(CNTR_MF_GDS_DESC,' '),chr(10),' ') D_DESC," ).append("\n"); 
		query.append("	   	replace(CNTR_MF_MK_DESC,chr(10),chr(10)) D_MARK" ).append("\n"); 
		query.append("FROM   	BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE	bkg_no    	=	@[form_bkg_no]" ).append("\n"); 
		query.append("AND		cntr_no(+)  =	@[in_cntr_no]" ).append("\n"); 

	}
}