/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchCmByCntrAtOutBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.06 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchCmByCntrAtOutBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, MxCmDetailInfoVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchCmByCntrAtOutBoundRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchCmByCntrAtOutBoundRSQL").append("\n"); 
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
		query.append("		'' D_CMDT --CMDT_CD D_CMDT" ).append("\n"); 
		query.append("        ,NVL(PCK_TP_CD, ' ') D_PUNIT" ).append("\n"); 
		query.append("        ,NVL(PCK_QTY, 0) D_PKG" ).append("\n"); 
		query.append("        ,DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) D_WGT" ).append("\n"); 
		query.append("        ,DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0))D_MEAS" ).append("\n"); 
		query.append("		,NVL(CMDT_HS_CD, ' ') D_HS_CD" ).append("\n"); 
		query.append("        ,BKG_TOKEN_NL_FNC(NVL(CNTR_MF_GDS_DESC,' '),0,'') D_DESC		" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(CNTR_MF_MK_DESC, CHR(13)||CHR(10), CHR(10)), CHR(10), CHR(10)||'D_MARK:') D_MARK" ).append("\n"); 
		query.append("  FROM  BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append(" WHERE  BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("   AND  CNTR_NO         =   @[cntr_no]" ).append("\n"); 

	}
}