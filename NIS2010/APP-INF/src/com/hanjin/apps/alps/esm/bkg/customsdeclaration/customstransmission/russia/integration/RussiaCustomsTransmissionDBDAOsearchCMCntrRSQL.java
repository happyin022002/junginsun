/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCMCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCMCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCMCntr
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCMCntrRSQL(){
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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration ").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCMCntrRSQL").append("\n"); 
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
		query.append("SELECT A1.CNTR_MF_SEQ           --CM_SEQ" ).append("\n"); 
		query.append(", BKG_SPCLCHAR_CONV_FNC(A1.CNTR_MF_GDS_DESC, 'C') CNTR_MF_GDS_DESC         --CM_DESC1" ).append("\n"); 
		query.append(", BKG_SPCLCHAR_CONV_FNC(TRIM(REPLACE(REPLACE(UPPER(A1.CNTR_MF_MK_DESC),CHR(13)||CHR(10),' '),CHR(9),' ')), 'C') CNTR_MF_MK_DESC1                                                                         " ).append("\n"); 
		query.append(",'' CNTR_MF_MK_DESC2" ).append("\n"); 
		query.append(",'' CNTR_MF_MK_DESC3" ).append("\n"); 
		query.append(",'' CNTR_MF_MK_DESC4" ).append("\n"); 
		query.append(",'' CNTR_MF_MK_DESC5" ).append("\n"); 
		query.append(", A1.CNTR_MF_WGT        --CM_WGT" ).append("\n"); 
		query.append(", A1.PCK_QTY            --CM_PKG" ).append("\n"); 
		query.append(", A1.PCK_TP_CD          --CM_PKG_U" ).append("\n"); 
		query.append(", A1.RC_FLG             --CM_REEFER_IND" ).append("\n"); 
		query.append(",   (SELECT CASE WHEN FDO_TEMP IS NOT NULL THEN FDO_TEMP" ).append("\n"); 
		query.append("            WHEN CDO_TEMP <> 0 THEN CDO_TEMP END FROM BKG_CSTMS_CHN_RF WHERE BL_NO=A1.BKG_NO AND CNTR_NO=A1.CNTR_NO" ).append("\n"); 
		query.append("			AND CHN_MF_SND_IND_CD = @[trans_mode] )  DO_TEMP    --CM_REEFER Temperature" ).append("\n"); 
		query.append(",   (SELECT CASE WHEN FDO_TEMP IS NOT NULL THEN 'F' ELSE DECODE(CDO_TEMP,0,'','C') END FROM BKG_CSTMS_CHN_RF " ).append("\n"); 
		query.append("			WHERE BL_NO=A1.BKG_NO AND CNTR_NO=A1.CNTR_NO AND CHN_MF_SND_IND_CD = @[trans_mode] ) TEMP_UN --CM_RUNIT Temperature Unit" ).append("\n"); 
		query.append(",   A1.MEAS_QTY           --CM_MEA" ).append("\n"); 
		query.append(",   '1' AS GOODNO         --CM_GOODNO" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC A1    ,BKG_CONTAINER A2" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND     A1.CNTR_NO = A2.CNTR_NO" ).append("\n"); 
		query.append("ORDER BY A2.CNTR_DP_SEQ     ,A1.CNTR_MF_SEQ" ).append("\n"); 

	}
}