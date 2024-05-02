/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchCmByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.04.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchCmByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR Desc 정보를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchCmByCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchCmByCntrRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("		'' D_CMDT" ).append("\n"); 
		query.append("        ,PCK_TP_CD D_PUNIT" ).append("\n"); 
		query.append("        ,NVL(PCK_QTY, 0) D_PKG" ).append("\n"); 
		query.append("        ,DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) D_WGT" ).append("\n"); 
		query.append("        ,DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0))D_MEAS" ).append("\n"); 
		query.append("        ,BKG_TOKEN_NL_FNC(NVL(CNTR_MF_GDS_DESC,' '),0,'') D_DESC" ).append("\n"); 
		query.append("		,CSTMS_DECL_NO D_CTMS_REF" ).append("\n"); 
		query.append("		,HAMO_TRF_CD D_HTS_CD" ).append("\n"); 
		query.append("		,CMDT_HS_CD D_HS_CD" ).append("\n"); 
		query.append("        ,NCM_NO D_NCM_CD" ).append("\n"); 
		query.append("        ,DECODE(CNTR_MF_MK_DESC, NULL, TO_CLOB('')," ).append("\n"); 
		query.append("               'D_MARK:' || REPLACE(REPLACE(TO_CLOB(CNTR_MF_MK_DESC), CHR(13)||CHR(10), CHR(10)), CHR(10), CHR(10)||'D_MARK:')) D_MARK" ).append("\n"); 
		query.append("  FROM  BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append(" WHERE  BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("   AND  CNTR_NO         =   @[cntr_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_MF_SEQ" ).append("\n"); 

	}
}