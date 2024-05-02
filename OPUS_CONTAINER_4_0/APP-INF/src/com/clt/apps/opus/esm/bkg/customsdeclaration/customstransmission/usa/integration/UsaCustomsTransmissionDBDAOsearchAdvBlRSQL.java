/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchAdvBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.04.19 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchAdvBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, BKG_CSTMS_ADV_BL조회.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchAdvBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchAdvBlRSQL").append("\n"); 
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
		query.append("SELECT IF_DT" ).append("\n"); 
		query.append(",USA_LST_LOC_CD" ).append("\n"); 
		query.append(",CSTMS_ACK_RJCT_MSG" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append(",FROB_FLG" ).append("\n"); 
		query.append(",IN_TZ_YD_CNT_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_STE_CD" ).append("\n"); 
		query.append(",PRE_MF_NO" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",USR_CMT_CTNT" ).append("\n"); 
		query.append(",TRSP_MOD_ID" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_ADDR" ).append("\n"); 
		query.append(",CSTMS_ACK_KEY_NO" ).append("\n"); 
		query.append(",FAX_OFC_CD" ).append("\n"); 
		query.append(",AMS_PCK_TP_CD" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",CSTMS_POD_CD" ).append("\n"); 
		query.append(",BDR_OFC_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",CSTMS_PORT_CD" ).append("\n"); 
		query.append(",CSTMS_ACK_RCV_DT" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",CSTMS_LOC_CD" ).append("\n"); 
		query.append(",AMDT_SND_DT" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",IF_FLG" ).append("\n"); 
		query.append(",VSL_ARR_DT" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",CA_ISS_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CSTMS_ACK_RJCT_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_ZIP_ID" ).append("\n"); 
		query.append(",CSTMS_FILE_LOC_CD" ).append("\n"); 
		query.append(",BDR_IF_DT" ).append("\n"); 
		query.append(",FAX_NO" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",BDR_IF_USR_ID" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",CSTMS_POL_CD" ).append("\n"); 
		query.append(",MF_NO" ).append("\n"); 
		query.append(",BDR_FLG" ).append("\n"); 
		query.append(",AVC_NOTE_TP_ID" ).append("\n"); 
		query.append(",MF_STS_CD" ).append("\n"); 
		query.append(",CSTMS_MF_TP_CD" ).append("\n"); 
		query.append(",FAX_CNT_CD" ).append("\n"); 
		query.append(",SCAC_CD" ).append("\n"); 
		query.append(",CSTMS_ACK_RCV_RSLT_CD" ).append("\n"); 
		query.append(",MF_SND_DT" ).append("\n"); 
		query.append(",MEAS_QTY" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",BDR_DT" ).append("\n"); 
		query.append(",CA_FLG" ).append("\n"); 
		query.append(",CSTMS_ACK_PROC_RSLT_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_CTY_NM" ).append("\n"); 
		query.append(",RCV_TERM_CD" ).append("\n"); 
		query.append(",FAX_CUST_SEQ" ).append("\n"); 
		query.append(",MEAS_UT_CD" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",IN_TZ_YD_CD" ).append("\n"); 
		query.append(",TRSP_TP_ID" ).append("\n"); 
		query.append(",CSTMS_TRSM_STS_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_NM" ).append("\n"); 
		query.append(",DE_TERM_CD" ).append("\n"); 
		query.append(",IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",CA_NO" ).append("\n"); 
		query.append(",HUB_LOC_CD" ).append("\n"); 
		query.append(",ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append(",(SELECT POD_CD FROM BKG_BOOKING WHERE BL_NO = @[bl_no]) IBFLAG" ).append("\n"); 
		query.append(",(SELECT ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD='US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='AMS_TML_CD_MAP'" ).append("\n"); 
		query.append("AND ATTR_CTNT1= POD_NOD_CD" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(") AMS_TML_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}