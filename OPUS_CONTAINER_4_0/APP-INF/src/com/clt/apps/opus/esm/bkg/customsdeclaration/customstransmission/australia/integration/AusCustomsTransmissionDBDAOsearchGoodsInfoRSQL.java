/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchGoodsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchGoodsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchGoodsInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchGoodsInfoRSQL").append("\n"); 
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
		query.append("SELECT MD.CNTR_MF_SEQ," ).append("\n"); 
		query.append("       MD.PCK_QTY," ).append("\n"); 
		query.append("       NVL(CNV.CSTMS_PCK_TP_CD, 'PK') AS PCK_TP_CD," ).append("\n"); 
		query.append("       MD.CNTR_MF_WGT," ).append("\n"); 
		query.append("       MD.WGT_UT_CD," ).append("\n"); 
		query.append("       MD.MEAS_QTY," ).append("\n"); 
		query.append("       MD.MEAS_UT_CD," ).append("\n"); 
		query.append("       MD.CMDT_HS_CD," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_CLOB_FNC(MD.CNTR_MF_GDS_DESC, 'Y') AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC MD," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE MD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND MD.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND MD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'AU'" ).append("\n"); 

	}
}