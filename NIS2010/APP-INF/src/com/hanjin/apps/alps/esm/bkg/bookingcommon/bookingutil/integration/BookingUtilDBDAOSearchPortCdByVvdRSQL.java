/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPortCdByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.09.20 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPortCdByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd기준으로 port항목 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPortCdByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPortCdByVvdRSQL").append("\n"); 
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
		query.append("SELECT	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	VPS_PORT_CD" ).append("\n"); 
		query.append(",	CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	CLPT_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",	PF_ETA_DT" ).append("\n"); 
		query.append(",	PF_ETB_DT" ).append("\n"); 
		query.append(",	PF_ETD_DT" ).append("\n"); 
		query.append(",	INIT_ETA_DT" ).append("\n"); 
		query.append(",	INIT_ETB_DT" ).append("\n"); 
		query.append(",	INIT_ETD_DT" ).append("\n"); 
		query.append(",	VPS_ETA_DT" ).append("\n"); 
		query.append(",	VPS_ETB_DT" ).append("\n"); 
		query.append(",	VPS_ETD_DT" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",	VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append(",	SHP_CALL_NO" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_USR_ID" ).append("\n"); 
		query.append(",	SHP_CALL_NO_UPD_DT" ).append("\n"); 
		query.append(",	TML_VSL_CD" ).append("\n"); 
		query.append(",	TML_VOY_NO" ).append("\n"); 
		query.append(",	FT_DT" ).append("\n"); 
		query.append(",	PLISM_YD_CD" ).append("\n"); 
		query.append(",	PLISM_VSL_CD" ).append("\n"); 
		query.append(",	PLISM_VOY_NO" ).append("\n"); 
		query.append(",	SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	TURN_PORT_FLG" ).append("\n"); 
		query.append(",	TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",	TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	IB_CGO_QTY" ).append("\n"); 
		query.append(",	OB_CGO_QTY" ).append("\n"); 
		query.append("--,	CRN_WRK_CMNC_DT" ).append("\n"); 
		query.append("--,	CRN_WRK_CMPL_DT" ).append("\n"); 
		query.append(",	VPS_RMK" ).append("\n"); 
		query.append(",	PHS_IO_RSN_CD" ).append("\n"); 
		query.append(",	PHS_IO_RMK" ).append("\n"); 
		query.append(",	SKD_BRTH_NO" ).append("\n"); 
		query.append(",	INIT_SKD_INP_FLG" ).append("\n"); 
		query.append(",	OFC_INP_FLG" ).append("\n"); 
		query.append(",	NOON_RPT_INP_FLG" ).append("\n"); 
		query.append(",	DEP_RPT_INP_FLG" ).append("\n"); 
		query.append(",	ACT_INP_FLG" ).append("\n"); 
		query.append(",	PRT_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	EDI_SND_KNT" ).append("\n"); 
		query.append(",	SKD_AUTO_UPD_FLG" ).append("\n"); 
		query.append(",	PORT_SKP_TP_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(",	PORT_SKP_RSN_OFFR_RMK" ).append("\n"); 
		query.append(",	TTL_DLAY_HRS" ).append("\n"); 
		query.append(",	TS_PORT_CD" ).append("\n"); 
		query.append(",	USD_FLG" ).append("\n"); 
		query.append(",	SLAN_CD || '|' || to_char(VPS_ETD_DT,'yyyy-mm-dd hh24:mi:ss') OPT_DISP" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("WHERE  SKD.VSL_CD 		= substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND    SKD.SKD_VOY_NO 	= substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND    SKD.SKD_DIR_CD 	= substr(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND    SKD.CLPT_IND_SEQ = (SELECT MAX(CLPT_IND_SEQ) " ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD  A" ).append("\n"); 
		query.append("                          WHERE A.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("                          AND   A.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND   A.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND   A.VPS_PORT_CD = SKD.VPS_PORT_CD)" ).append("\n"); 
		query.append("ORDER BY OPT_DISP, SKD.VPS_PORT_CD" ).append("\n"); 

	}
}