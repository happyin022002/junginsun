/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInterfaceMgtDAOSearchBkgInfoForINV_1RSQL.java
*@FileTitle : 11111
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingInterfaceMgtDAOSearchBkgInfoForINV_1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG ==> INV
	  * HEARDER 정보 조회
	  * </pre>
	  */
	public BookingInterfaceMgtDAOSearchBkgInfoForINV_1RSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration").append("\n"); 
		query.append("FileName : BookingInterfaceMgtDAOSearchBkgInfoForINV_1RSQL").append("\n"); 
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
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append(",	BOOKING_SER" ).append("\n"); 
		query.append(",	TIMESTAMP" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	BKG_STS_CD" ).append("\n"); 
		query.append(",	CANCEL_MK" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(",	BKG_CORR_DT" ).append("\n"); 
		query.append(",	CA_RSN" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	TRUNK_VSL_CD" ).append("\n"); 
		query.append(",	TRUNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",	TRUNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",	FIN_DIR_CD" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	CGO_WGT" ).append("\n"); 
		query.append(",	CGO_MEAS_QTY" ).append("\n"); 
		query.append(",	SREP_CD" ).append("\n"); 
		query.append(",	DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append(",	MST_BL_NO" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	BKG_REF_NO" ).append("\n"); 
		query.append(",	INV_REF_NO" ).append("\n"); 
		query.append(",	SI_REF_NO" ).append("\n"); 
		query.append(",	AUTO_RATING_DIVISION" ).append("\n"); 
		query.append(",	PPD_3RD_OFC1" ).append("\n"); 
		query.append(",	CCT_3RD_OFC1" ).append("\n"); 
		query.append(",	PPD_3RD_OFC2" ).append("\n"); 
		query.append(",	CCT_3RD_OFC2" ).append("\n"); 
		query.append(",	PPD_3RD_OFC3" ).append("\n"); 
		query.append(",	CCT_3RD_OFC3" ).append("\n"); 
		query.append(",	PPD_OFC" ).append("\n"); 
		query.append(",	CCT_OFC" ).append("\n"); 
		query.append(",	PPD_PAYR_CNT_CD" ).append("\n"); 
		query.append(",	PPD_PAYR_CUST_SEQ" ).append("\n"); 
		query.append(",	CLT_PAYR_CNT_CD" ).append("\n"); 
		query.append(",	CLT_PAYR_CUST_SEQ" ).append("\n"); 
		query.append(",	PPD_3RD_CNT1" ).append("\n"); 
		query.append(",	PPD_3RD_CUST1" ).append("\n"); 
		query.append(",	CCT_3RD_CNT1" ).append("\n"); 
		query.append(",	CCT_3RD_CUST1" ).append("\n"); 
		query.append(",	PPD_3RD_CNT2" ).append("\n"); 
		query.append(",	PPD_3RD_CUST2" ).append("\n"); 
		query.append(",	CCT_3RD_CNT2" ).append("\n"); 
		query.append(",	CCT_3RD_CUST2" ).append("\n"); 
		query.append(",	PPD_3RD_CNT3" ).append("\n"); 
		query.append(",	PPD_3RD_CUST3" ).append("\n"); 
		query.append(",	CCT_3RD_CNT3" ).append("\n"); 
		query.append(",	CCT_3RD_CUST3" ).append("\n"); 
		query.append(",	FRT_FWRD_CNT_CD" ).append("\n"); 
		query.append(",	FRT_FWRD_CUST_SEQ" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	BKG_TEU_QTY" ).append("\n"); 
		query.append(",	BKG_FEU_QTY" ).append("\n"); 
		query.append(",	POL_VVD" ).append("\n"); 
		query.append(",	POD_VVD" ).append("\n"); 
		query.append(",	ACT_SHPR" ).append("\n"); 
		query.append(",	WHF_DLC_NO" ).append("\n"); 
		query.append(",	WHF_DLC_DT" ).append("\n"); 
		query.append(",	WHF_DLC_OFC_CD" ).append("\n"); 
		query.append(",	WHF_MRN_NO" ).append("\n"); 
		query.append(",	WHF_NTC_NO" ).append("\n"); 
		query.append(",	WHF_VVD" ).append("\n"); 
		query.append(",	CSR_NO" ).append("\n"); 
		query.append("FROM	table(BKG_INV_IF_PKG.BKG_IF_HEADER_TBL_FUNC(@[bkg_no]))" ).append("\n"); 

	}
}