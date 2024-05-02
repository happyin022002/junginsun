/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchCMRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("receiver_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
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
		query.append("      , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD = SUBSTR(@[cnt_gubun], 1, 2)" ).append("\n"); 
		query.append("               AND AA.RCVR_ID = DECODE(@[cnt_gubun], 'BR', 'ALL', DECODE(@[receiver_id], 'IMP', 'IMP', 'EU'))" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = A.PCK_TP_CD" ).append("\n"); 
		query.append("           ),PCK_TP_CD) AS D_PUNIT" ).append("\n"); 
		query.append("      , PCK_QTY D_PKG" ).append("\n"); 
		query.append("      , DECODE(NVL(WGT_UT_CD,' '),'LBS',ROUND(NVL(CNTR_MF_WGT,0)*0.4536,3),NVL(CNTR_MF_WGT,0)) D_WGT" ).append("\n"); 
		query.append("      , DECODE(NVL(MEAS_UT_CD,' '),'CBF',ROUND(NVL(MEAS_QTY,0)*0.0283,3),NVL(MEAS_QTY,0))D_MEAS" ).append("\n"); 
		query.append("      , REPLACE(REPLACE(REPLACE(CNTR_MF_GDS_DESC, CHR(13)||CHR(10),' '), CHR(13), ' '), CHR(10), ' ') D_DESC" ).append("\n"); 
		query.append("      , HAMO_TRF_CD HAMO_TRF_CD" ).append("\n"); 
		query.append("      , DECODE(CNTR_MF_MK_DESC, NULL, TO_CLOB('')," ).append("\n"); 
		query.append("               'D_MARK:' || REPLACE(REPLACE(TO_CLOB(CNTR_MF_MK_DESC), CHR(13)||CHR(10), CHR(10)), CHR(10), CHR(10)||'D_MARK:')) D_MARK" ).append("\n"); 
		query.append("      , A.CNTR_MF_SEQ" ).append("\n"); 
		query.append("  FROM  BKG_CNTR_MF_DESC A" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}