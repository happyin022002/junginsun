/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchCMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchCMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR DESC 정보를 조회한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchCMRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchCMRSQL").append("\n"); 
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
		query.append("SELECT  CMDT_HS_CD D_CMDT" ).append("\n"); 
		query.append("      , PCK_TP_CD D_PUNIT" ).append("\n"); 
		query.append("      , PCK_QTY D_PKG" ).append("\n"); 
		query.append("      , DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) D_WGT" ).append("\n"); 
		query.append("      , DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0))D_MEAS" ).append("\n"); 
		query.append("      , CNTR_MF_GDS_DESC D_DESC" ).append("\n"); 
		query.append("      , HAMO_TRF_CD HAMO_TRF_CD " ).append("\n"); 
		query.append("      , B.BRZ_CMDT_CD D_NCM_CD" ).append("\n"); 
		query.append("      , CASE WHEN CNTR_MF_MK_DESC IS NULL THEN TO_CLOB('')" ).append("\n"); 
		query.append("             ELSE 'D_MARK:' || replace(TO_CLOB(CNTR_MF_MK_DESC) ,chr(13)||chr(10),chr(10)||'D_MARK:')" ).append("\n"); 
		query.append("        END D_MARK" ).append("\n"); 
		query.append("      , B.CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , (CASE WHEN A.WPM_TRT_CD = 'A' THEN 'N/A' ELSE NVL(A.WPM_TRT_CD,' ') END) WPM" ).append("\n"); 
		query.append("FROM    BKG_CNTR_MF_DESC A" ).append("\n"); 
		query.append("      , BKG_CSTMS_BRZ_CNTR_MF B" ).append("\n"); 
		query.append("      , BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     BB.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND     BB.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND     A.CNTR_NO = B.CNTR_NO(+)  " ).append("\n"); 
		query.append("AND     A.CNTR_MF_SEQ = B.CNTR_MF_SEQ(+)" ).append("\n"); 
		query.append("AND     A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND     A.CNTR_MF_SEQ > 0" ).append("\n"); 

	}
}