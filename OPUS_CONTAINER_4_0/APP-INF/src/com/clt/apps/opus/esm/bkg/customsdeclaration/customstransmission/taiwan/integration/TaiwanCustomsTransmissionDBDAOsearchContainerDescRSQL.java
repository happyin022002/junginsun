/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest Container Description 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchContainerDescRSQL").append("\n"); 
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
		query.append("SELECT ' ' AS D_CMDT," ).append("\n"); 
		query.append("       NVL(NVL(CNV.CSTMS_PCK_TP_CD, MD.PCK_TP_CD), ' ') AS D_PUNIT, " ).append("\n"); 
		query.append("       NVL(MD.PCK_QTY, 0) AS D_PKG, " ).append("\n"); 
		query.append("       DECODE(NVL(MD.WGT_UT_CD, ' '), 'LBS', ROUND(NVL(MD.CNTR_MF_WGT, 0) * 0.4536, 3), NVL(MD.CNTR_MF_WGT, 0)) AS D_WGT, " ).append("\n"); 
		query.append("       DECODE(NVL(MD.MEAS_UT_CD, ' '), 'CBF', ROUND(NVL(MD.MEAS_QTY, 0) * 0.0283, 3), NVL(MD.MEAS_QTY, 0)) AS D_MEA, " ).append("\n"); 
		query.append("       TRANSLATE(NVL(MD.CNTR_MF_GDS_DESC, ' '), CHR(10), ' ') AS CNTR_DESC, " ).append("\n"); 
		query.append("       DECODE(MD.CNTR_MF_MK_DESC, NULL, '', '{CUS_MARK'||CHR(10)||'D_MARK:' ||REPLACE(MD.CNTR_MF_MK_DESC, CHR(10), CHR(10)||'D_MARK:')||CHR(10)||'}CUS_MARK'||CHR(10) ) AS ST_13" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM  BKG_CNTR_MF_DESC MD," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE MD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND MD.CNTR_NO(+) = @[cntr_no]" ).append("\n"); 
		query.append("   AND MD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'TW'" ).append("\n"); 

	}
}