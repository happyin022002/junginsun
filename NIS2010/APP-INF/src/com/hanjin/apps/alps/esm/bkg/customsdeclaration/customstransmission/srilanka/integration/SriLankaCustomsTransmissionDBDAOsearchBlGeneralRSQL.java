/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("vvd_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
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
		query.append("#if(${ver_flg}=='O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '{BL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	    #if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("					'BLNBR:'||'SMLM'||NVL(BKG.BL_NO,' ')||DECODE(NVL(BKG.BL_TP_CD,' '),'S',' ','W',' ',NVL(BKG.BL_TP_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'BLNBR:'||'EMPTY_SML'||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				'DOC_TP:'|| (SELECT CASE WHEN @[pod_cd] = @[vvd_pod] and @[vvd_pod] ='LKCMB' THEN '23'" ).append("\n"); 
		query.append("         					   WHEN @[pod_cd] != @[vvd_pod] and @[vvd_pod] ='LKCMB' THEN '28'" ).append("\n"); 
		query.append("					           ELSE '23' END" ).append("\n"); 
		query.append("							   FROM DUAL) ||CHR(10)||" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("           	    'BLPOL:'||@[pol_cd]||CHR(10)||  " ).append("\n"); 
		query.append("           	    'BLPOD:'||NVL(BKG.POD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR1:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR2:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR3:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR4:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR5:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'CNEE1:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'CNEE1:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	    'CNEE2:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'CNEE3:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'CNEE3:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           	    " ).append("\n"); 
		query.append("           	    'CNEE4:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           		'CNEE5:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'NTFY1:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'NTFY1:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           		" ).append("\n"); 
		query.append("           		'NTFY2:'||SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'NTFY3:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'NTFY3:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           		" ).append("\n"); 
		query.append("           		'NTFY4:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           		'NTFY5:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("           			'BLPKG:'||@[pck_qty]||CHR(10)||  " ).append("\n"); 
		query.append("           			'BLPKGU:'||@[pck_tp_cd]||CHR(10)||  " ).append("\n"); 
		query.append("           			'BLWGT:'||@[act_wgt]||CHR(10)||  " ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					#if(${cntr_no} != '')" ).append("\n"); 
		query.append("					'BLPKG:'||@[cntr_cnt]||CHR(10)||" ).append("\n"); 
		query.append("					'BLPKGU:'||'CN'||CHR(10)|| " ).append("\n"); 
		query.append("					'BLWGT:'||@[cntr_cnt]||CHR(10)|| " ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					(select 'BLPKG:'||count(*) from bkg_container c where c.bkg_no = @[bkg_no])||CHR(10)||" ).append("\n"); 
		query.append("           			'BLPKGU:'||'CN'||CHR(10)||  " ).append("\n"); 
		query.append("					(select 'BLWGT:'||count(*) from bkg_container c where c.bkg_no = @[bkg_no])||CHR(10)|| " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					          			" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           		'BL_WGT_UNIT:'||@[wgt_ut_cd]||CHR(10)||  " ).append("\n"); 
		query.append("           		'BLMEA:'||@[meas_qty]||CHR(10)|| " ).append("\n"); 
		query.append("           		'BL_MEA_UNIT:'||@[meas_ut_cd]||CHR(10)  bl_desc" ).append("\n"); 
		query.append("      	FROM   BKG_BOOKING BKG, BKG_CUSTOMER BCC, BKG_CUSTOMER BCS, BKG_CUSTOMER BCN, MDM_LOCATION MDM_LOC, MDM_ORGANIZATION MDM_ORG" ).append("\n"); 
		query.append("    	WHERE  BKG.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCC.BKG_NO" ).append("\n"); 
		query.append("		AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("		AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCN.BKG_NO" ).append("\n"); 
		query.append("		AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("		AND BKG.POD_CD = MDM_LOC.LOC_CD" ).append("\n"); 
		query.append("		AND MDM_LOC.EQ_CTRL_OFC_CD = MDM_ORG.OFC_CD" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '{BL_INFO'||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	    #if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("					'BLNBR:'||'SMLM'||NVL(BKG.BL_NO,' ')||DECODE(NVL(BKG.BL_TP_CD,' '),'S',' ','W',' ',NVL(BKG.BL_TP_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'BLNBR:'||'EMPTY_SML'||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                'BL_TYPE:'||'MB'||CHR(10)||" ).append("\n"); 
		query.append("                'MBL_NO:'||NVL(BKG.BL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                #if (${edi_mt_removal} != 'M')" ).append("\n"); 
		query.append("           			'BLPKG:'||@[pck_qty]||CHR(10)||  " ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					#if(${cntr_no} != '')" ).append("\n"); 
		query.append("					'BLPKG:'||@[cntr_cnt]||CHR(10)||" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					(select 'BLPKG:'||count(*) from bkg_container c where c.bkg_no = @[bkg_no])||CHR(10)||" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					          			" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("				'BLPOR:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.POR_CD),BKG.POR_CD)||CHR(10)||" ).append("\n"); 
		query.append("				'ORIGIN_PORT:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.POL_CD),BKG.POL_CD)||CHR(10)||" ).append("\n"); 
		query.append("				'BLPOL:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = @[pol_cd]),@[pol_cd])||CHR(10)||  " ).append("\n"); 
		query.append("				'BLPOD:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.POD_CD),BKG.POD_CD)||CHR(10)||" ).append("\n"); 
		query.append("				'DEL:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD),BKG.DEL_CD)||CHR(10)||" ).append("\n"); 
		query.append("				'FINAL_DEST:'||NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = BKG.DEL_CD),BKG.DEL_CD)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           	    'SHPR1:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR2:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("           	    'SHPR3:'||SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("				'SHPR4:'||SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'CNEE1:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE2:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE3:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE4:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'CNEE1:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE2:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE3:'||SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("				'CNEE4:'||SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${edi_mt_removal} == 'M')" ).append("\n"); 
		query.append("				'NTFY1:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,1)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY2:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ENG_NM,2)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY3:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY4:'||SCE_TOKEN_NL_FNC(MDM_ORG.OFC_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'NTFY1:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY2:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY3:'||SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("				'NTFY4:'||SCE_TOKEN_NL_FNC(NVL(TRIM(BCN.CUST_NM),BCC.CUST_NM),1)||CHR(10)||" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("           		" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("				'FFWD1:'||SCE_TOKEN_NL_FNC(BCF.CUST_ADDR,1)||CHR(10)||" ).append("\n"); 
		query.append("				'FFWD2:'||SCE_TOKEN_NL_FNC(BCF.CUST_ADDR,2)||CHR(10)||" ).append("\n"); 
		query.append("				'FFWD3:'||SCE_TOKEN_NL_FNC(BCF.CUST_ADDR,3)||CHR(10)||" ).append("\n"); 
		query.append("				'FFWD4:'||SCE_TOKEN_NL_FNC(BCF.CUST_NM,1)||CHR(10)  bl_desc" ).append("\n"); 
		query.append("      	FROM   BKG_BOOKING BKG, BKG_CUSTOMER BCC, BKG_CUSTOMER BCS, BKG_CUSTOMER BCN, BKG_CUSTOMER BCF, MDM_LOCATION MDM_LOC, MDM_ORGANIZATION MDM_ORG" ).append("\n"); 
		query.append("    	WHERE  BKG.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCC.BKG_NO" ).append("\n"); 
		query.append("		AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("		AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO=BCN.BKG_NO" ).append("\n"); 
		query.append("		AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO = BCF.BKG_NO" ).append("\n"); 
		query.append("		AND BCF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("		AND BKG.POD_CD = MDM_LOC.LOC_CD" ).append("\n"); 
		query.append("		AND MDM_LOC.EQ_CTRL_OFC_CD = MDM_ORG.OFC_CD" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}