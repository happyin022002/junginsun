/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOMdmLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOMdmLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OpfUtilDBDAOMdmLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOMdmLocationVORSQL").append("\n"); 
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
		query.append("SELECT		MAX(DECODE(MO.OFC_TP_CD, 'HQ', MO.OFC_CD))	AS NAME    " ).append("\n"); 
		query.append("			--,MAX(SELECT ML.SLS_OFC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = 'AEJEA')                            AS OFC_CD    " ).append("\n"); 
		query.append("FROM		MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("CONNECT BY 	NOCYCLE PRIOR MO.PRNT_OFC_CD	= MO.OFC_CD" ).append("\n"); 
		query.append("START WITH 	MO.OFC_CD 						= (SELECT ML.SLS_OFC_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = @[loc_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT  CASE WHEN DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                  THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'VSK'))) -- EUROPE REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("--             WHEN CONTI_CD  = 'M' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                  THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000002', 'VSK'))) -- AMERICA REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("--             WHEN CONTI_CD  = 'A' AND NVL(DELT_FLG, 'N') = 'N' AND CALL_PORT_FLG = 'Y' --AND SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("--                  THEN (SELECT OFC_CD FROM TABLE(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000003', 'VSK'))) -- ASIA REGIONAL HEADQUARTERS" ).append("\n"); 
		query.append("--        END  AS NAME" ).append("\n"); 
		query.append("--FROM    MDM_LOCATION" ).append("\n"); 
		query.append("--WHERE   LOC_CD         = [loc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SELECT     MM.AR_HD_QTR_OFC_CD  AS NAME" ).append("\n"); 
		query.append("--FROM       MDM_ORGANIZATION     MM   " ).append("\n"); 
		query.append("--WHERE      1 = 1" ).append("\n"); 
		query.append("--AND        MM.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("--AND        MM.OFC_CD            = [ofc_cd]" ).append("\n"); 

	}
}