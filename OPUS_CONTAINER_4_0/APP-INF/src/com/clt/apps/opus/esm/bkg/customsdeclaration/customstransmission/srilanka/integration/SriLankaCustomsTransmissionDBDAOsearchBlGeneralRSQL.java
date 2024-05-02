/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.02.24 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카 세관 신고용 Manifest B/L General 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT '{BL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("           	    'BLNBR:'||COM_ConstantMgr_PKG.COM_getScacCode_FNC()||NVL(BKG.BL_NO,' ')||DECODE(NVL(BKG.BL_TP_CD,' '),'S',' ',NVL(BKG.BL_TP_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("           	    'BLPOL:'||@[pol_cd]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           	    'BLPOD:'||NVL(BKG.POD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR1:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR2:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR3:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR4:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR5:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("           	    'CNEE1:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'CNEE2:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'CNEE3:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'CNEE4:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           		'CNEE5:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY1:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY2:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY3:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY4:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY5:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("           		'BLPKG:'||@[pck_qty]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           		'BLPKGU:'||@[pck_tp_cd]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           		'BLWGT:'||@[act_wgt]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           		'BL_WGT_UNIT:'||@[wgt_ut_cd]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           		'BLMEA:'||@[meas_qty]||CHR(10)||  -- 화면에서 받은 값" ).append("\n"); 
		query.append("           		'BL_MEA_UNIT:'||@[meas_ut_cd]||CHR(10)  bl_desc" ).append("\n"); 
		query.append("      	FROM   BKG_BOOKING BKG, BKG_CUSTOMER BCC, BKG_CUSTOMER BCS, BKG_CUSTOMER BCN" ).append("\n"); 
		query.append("    	WHERE  BKG.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCC.BKG_NO" ).append("\n"); 
		query.append("		AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("		AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCN.BKG_NO" ).append("\n"); 
		query.append("		AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 

	}
}