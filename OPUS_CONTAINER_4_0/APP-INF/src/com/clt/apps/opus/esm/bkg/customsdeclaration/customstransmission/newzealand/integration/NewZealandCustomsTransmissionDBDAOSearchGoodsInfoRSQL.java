/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandCustomsTransmissionDBDAOSearchGoodsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandCustomsTransmissionDBDAOSearchGoodsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandCustomsTransmissionDBDAOSearchGoodsInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandCustomsTransmissionDBDAOSearchGoodsInfoRSQL").append("\n"); 
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
		query.append("SELECT DSC.CNTR_MF_SEQ AS CM_SEQ," ).append("\n"); 
		query.append("       DSC.PCK_QTY AS BLPKG," ).append("\n"); 
		query.append("       DECODE(CNV.CSTMS_PCK_TP_CD, NULL, DSC.PCK_TP_CD, CNV.CSTMS_PCK_TP_CD) AS BLPKGU," ).append("\n"); 
		query.append("       DSC.CNTR_MF_WGT AS BLWGT," ).append("\n"); 
		query.append("       DSC.WGT_UT_CD AS BLWGT_UNIT," ).append("\n"); 
		query.append("       DSC.MEAS_QTY AS BLMEA," ).append("\n"); 
		query.append("       DSC.MEAS_UT_CD AS BLMEA_UNIT," ).append("\n"); 
		query.append("       DSC.CMDT_HS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC DSC," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND DSC.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'NZ'" ).append("\n"); 

	}
}