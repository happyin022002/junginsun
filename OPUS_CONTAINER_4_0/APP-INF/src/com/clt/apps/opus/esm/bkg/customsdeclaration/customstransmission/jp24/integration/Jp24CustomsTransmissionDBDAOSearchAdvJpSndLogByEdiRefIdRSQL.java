/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByEdiRefIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByEdiRefIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByEdiRefIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchAdvJpSndLogByEdiRefIdRSQL").append("\n"); 
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
		query.append("SELECT SND.JP_SND_LOG_ID," ).append("\n"); 
		query.append("       SND.MSG_SND_NO," ).append("\n"); 
		query.append("       SND.RCV_KEY_DAT_CTNT," ).append("\n"); 
		query.append("       SND.BL_NO," ).append("\n"); 
		query.append("       '' AS HBL_NO," ).append("\n"); 
		query.append("       SND.VSL_CD||SND.SKD_VOY_NO||SND.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       SND.POL_CD," ).append("\n"); 
		query.append("       (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("         WHERE LOC.LOC_CD = SND.POL_CD) AS POL_NM," ).append("\n"); 
		query.append("       SND.POD_CD," ).append("\n"); 
		query.append("       (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("          FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("         WHERE LOC.LOC_CD = SND.POD_CD) AS POD_NM," ).append("\n"); 
		query.append("       SND.POR_CD," ).append("\n"); 
		query.append("       SND.EDI_SND_MSG_CTNT," ).append("\n"); 
		query.append("       (SELECT IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_VSL_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD = SND.VSL_CD" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SND.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SND.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND POL_CD = SND.POL_CD) AS IB_CSSM_VOY_NO," ).append("\n"); 
		query.append("       (SELECT S.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER S," ).append("\n"); 
		query.append("               BKG_BOOKING BKG" ).append("\n"); 
		query.append("         WHERE S.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BL_NO = SND.BL_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD = 'S') AS SHPR_NM," ).append("\n"); 
		query.append("       (SELECT C.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER C," ).append("\n"); 
		query.append("               BKG_BOOKING BKG" ).append("\n"); 
		query.append("         WHERE C.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BL_NO = SND.BL_NO" ).append("\n"); 
		query.append("           AND C.BKG_CUST_TP_CD = 'C') AS CNEE_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE EDI_REF_ID = @[edi_ref_id]" ).append("\n"); 

	}
}