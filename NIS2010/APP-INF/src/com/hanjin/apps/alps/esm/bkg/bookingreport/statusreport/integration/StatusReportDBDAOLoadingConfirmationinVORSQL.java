/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StatusReportDBDAOLoadingConfirmationinVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOLoadingConfirmationinVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 고객에게 Container Loading Confirmation을 발송하는 기능
	  * Loading Confirmation by Shipper (Fax / E-Mail)
	  * 2011.06.03 이일민 [CHM-201111164] Loading Confimation by Shipper기능 - VVD조회조건 FEEDER포함
	  * </pre>
	  */
	public StatusReportDBDAOLoadingConfirmationinVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOLoadingConfirmationinVORSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER( ORDER BY BKG_NO) RNUM" ).append("\n"); 
		query.append(",	CUST_NM" ).append("\n"); 
		query.append(",	BKG_C_PERSON" ).append("\n"); 
		query.append(",	SKD_VOY_DIR" ).append("\n"); 
		query.append(",	VPS_ETD_DT" ).append("\n"); 
		query.append(",	BKG_REF_NO" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	'' POL_LOC_CD" ).append("\n"); 
		query.append(",	'' POD_LOC_CD" ).append("\n"); 
		query.append(",	'' DEL_LOC_CD" ).append("\n"); 
		query.append(",	CNMV_STS_CD" ).append("\n"); 
		query.append(",	CUST_FULL_NM" ).append("\n"); 
		query.append(",	BKG_OFC_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",	CNTC_PSON_EML" ).append("\n"); 
		query.append(",	BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",	VVD_CD" ).append("\n"); 
		query.append(",	SND_DT" ).append("\n"); 
		query.append(",	BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(",	LANGUAGE" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	OFC_ENG_NM" ).append("\n"); 
		query.append(",	OFC_ADDR" ).append("\n"); 
		query.append(",	OFC_PHN_NO" ).append("\n"); 
		query.append(",	FAX_IP" ).append("\n"); 
		query.append(",	AR_CURR_CD" ).append("\n"); 
		query.append(",	RD_PARAM" ).append("\n"); 
		query.append(",	MPHN_NO" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	SUBGROUP_TITLE" ).append("\n"); 
		query.append(",	'' RCHECK" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT /*+ rule */ TRANSLATE(NVL(CUSTOMER.CUST_LGL_ENG_NM,' '),CHR(13)||CHR(10),' ') CUST_NM --TRANSLATE(NVL(CUSTOMER.CUST_NM,' '),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append(",       PS.CNTC_PSON_NM  BKG_C_PERSON                                             -- NVL(BK.BKG_C_PERSON,' ')" ).append("\n"); 
		query.append(",       TRANSLATE(NVL(VSL.VSL_ENG_NM,' '),CHR(13)||CHR(10),' ')||' '||NVL(BK.SKD_VOY_NO,' ')||' '||NVL(BK.SKD_DIR_CD,' ') SKD_VOY_DIR" ).append("\n"); 
		query.append(",       NVL(TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS'),' ') VPS_ETD_DT" ).append("\n"); 
		query.append(",       (SELECT BR.CUST_REF_NO_CTNT  FROM  BKG_REFERENCE BR WHERE BR.BKG_NO =  BK.BKG_NO   AND BR.BKG_REF_TP_CD = 'EBRF' )  BKG_REF_NO --NVL(BK.BKG_REF_NO,' ')" ).append("\n"); 
		query.append(",       BK.BKG_NO" ).append("\n"); 
		query.append(",       BK.POR_CD" ).append("\n"); 
		query.append(",       BK.POL_CD" ).append("\n"); 
		query.append(",       BK.POD_CD" ).append("\n"); 
		query.append(",       BK.DEL_CD" ).append("\n"); 
		query.append(",       CNTR.CNTR_NO" ).append("\n"); 
		query.append("--,       TRANSLATE(NVL(POL.LOC_CD,' '),CHR(13)||CHR(10),' ') POL_LOC_CD" ).append("\n"); 
		query.append("--,       TRANSLATE(NVL(POD.LOC_CD,' '),CHR(13)||CHR(10),' ') POD_LOC_CD" ).append("\n"); 
		query.append("--,       TRANSLATE(NVL(DEL.LOC_CD,' '),CHR(13)||CHR(10),' ') DEL_LOC_CD" ).append("\n"); 
		query.append(",       CNTR.CNMV_STS_CD                        --NVL(CNTR.BCNTR_CNMV_CD,' ')" ).append("\n"); 
		query.append(",       NVL(CUST.CUST_CNT_CD,' ')||' '||NVL(TO_CHAR(CUST.CUST_SEQ),' ')||'/'||TRANSLATE(NVL(SUBSTR(CUSTOMER.CUST_LGL_ENG_NM,1,15),' '),CHR(13)||CHR(10),' ') CUST_FULL_NM" ).append("\n"); 
		query.append(",       BK.BKG_OFC_CD                           --NVL(BK.BKG_OFC,' ')" ).append("\n"); 
		query.append(",       BK.VSL_CD" ).append("\n"); 
		query.append(",       BK.SKD_VOY_NO" ).append("\n"); 
		query.append(",       BK.SKD_DIR_CD" ).append("\n"); 
		query.append(",       BK.SC_NO                                --NVL(BRH.BRH_SC_NO, ' ')" ).append("\n"); 
		query.append(",       NVL(PS.CNTC_PSON_FAX_NO,' ')  CNTC_PSON_FAX_NO       -- NVL(BK.BKG_C_FAX,' ')" ).append("\n"); 
		query.append(",       NVL(PS.CNTC_PSON_EML,' ')      CNTC_PSON_EML         -- NVL(PS.CNTC_PSON_EML,' ')" ).append("\n"); 
		query.append(",       CUST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",       BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",       (SELECT SND_DT FROM BKG_NTC_HIS NTC WHERE NTC.BKG_NO = BK.BKG_NO AND NTC.HIS_SEQ =1 ) SND_DT" ).append("\n"); 
		query.append(",       PS.BKG_CNTC_PSON_TP_CD" ).append("\n"); 
		query.append(",		'' LANGUAGE" ).append("\n"); 
		query.append(",		CUST.CUST_CNT_CD" ).append("\n"); 
		query.append(",		CUST.CUST_SEQ" ).append("\n"); 
		query.append(",   	OFFICE.OFC_ENG_NM" ).append("\n"); 
		query.append(",   	OFFICE.OFC_ADDR" ).append("\n"); 
		query.append(",   	OFFICE.OFC_PHN_NO" ).append("\n"); 
		query.append(",   	OFFICE.FAX_IP" ).append("\n"); 
		query.append(",   	OFFICE.AR_CURR_CD  " ).append("\n"); 
		query.append(",		'' RD_PARAM" ).append("\n"); 
		query.append(",		'' MPHN_NO" ).append("\n"); 
		query.append(",		'' FAX_NO" ).append("\n"); 
		query.append(",		'POL : '|| BK.POL_CD  || '	/	' || 'Shipper : ' || NVL(CUST.CUST_CNT_CD,' ')||' '||NVL(TO_CHAR(CUST.CUST_SEQ),' ')||'/'||TRANSLATE(NVL(SUBSTR(CUSTOMER.CUST_LGL_ENG_NM,1,15),' '),CHR(13)||CHR(10),' ')   || '	Exchange Rate : 1 USD '  || TRIM(TO_CHAR(ROUND(DECODE(OFFICE.AR_CURR_CD,'GBP',1/RT.INV_XCH_RT,NVL(INV_XCH_RT,0)),4),'9999999999.9999')) || ' ' || NVL(RT.LOCL_CURR_CD,' ')   SUBGROUP_TITLE" ).append("\n"); 
		query.append("FROM    BKG_BOOKING  BK" ).append("\n"); 
		query.append(",       BKG_CNTC_PSON PS" ).append("\n"); 
		query.append(",       BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(",       BKG_CONTAINER CNTR     --BKG_CNTR CNTR" ).append("\n"); 
		query.append(",       VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(",       MDM_VSL_CNTR  VSL      --VSL VSL" ).append("\n"); 
		query.append(",       MDM_CUSTOMER CUSTOMER" ).append("\n"); 
		query.append("--,       MDM_LOCATION POL" ).append("\n"); 
		query.append("--,       MDM_LOCATION POD" ).append("\n"); 
		query.append("--,       MDM_LOCATION DEL" ).append("\n"); 
		query.append(",       BKG_VVD BV" ).append("\n"); 
		query.append(",       MDM_ORGANIZATION OFFICE" ).append("\n"); 
		query.append(",		(SELECT RT.INV_XCH_RT," ).append("\n"); 
		query.append("				RT.LOCL_CURR_CD," ).append("\n"); 
		query.append("				RT.VSL_CD,	" ).append("\n"); 
		query.append("				RT.SKD_VOY_NO," ).append("\n"); 
		query.append("				RT.SKD_DIR_CD," ).append("\n"); 
		query.append("				RT.PORT_CD," ).append("\n"); 
		query.append("				RT.IO_BND_CD," ).append("\n"); 
		query.append("				RT.CHG_CURR_CD," ).append("\n"); 
		query.append("				RT.SVC_SCP_CD," ).append("\n"); 
		query.append("				BK.BKG_NO" ).append("\n"); 
		query.append("			FROM INV_VVD_XCH_RT RT, BKG_BOOKING BK, MDM_ORGANIZATION OFFICE" ).append("\n"); 
		query.append("		   WHERE 1=1" ).append("\n"); 
		query.append("			#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("				 AND RT.VSL_CD         =   SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("				 AND RT.SKD_VOY_NO     =   SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("				 AND RT.SKD_DIR_CD     =   SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${pol_cd} != '') " ).append("\n"); 
		query.append("				AND     RT.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("				AND		BK.BKG_OFC_CD   = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				AND RT.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("	            AND RT.CHG_CURR_CD ='USD'" ).append("\n"); 
		query.append("           		AND RT.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("           		AND RT.SKD_VOY_NO =  BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           		AND RT.SKD_DIR_CD = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("           		AND RT.PORT_CD = BK.POL_CD" ).append("\n"); 
		query.append("           		AND BK.BKG_STS_CD IN ('F','S','W') " ).append("\n"); 
		query.append("           		AND RT.LOCL_CURR_CD = OFFICE.AR_CURR_CD" ).append("\n"); 
		query.append("				AND     BK.BKG_OFC_CD = OFFICE.OFC_CD " ).append("\n"); 
		query.append("           		AND RT.SVC_SCP_CD = NVL((SELECT   SVC_SCP_CD" ).append("\n"); 
		query.append("                         FROM  INV_VVD_XCH_RT RT " ).append("\n"); 
		query.append("                         WHERE    RT.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("                          AND     RT.SKD_VOY_NO =  BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND     RT.SKD_DIR_CD = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND     RT.PORT_CD = BK.POL_CD" ).append("\n"); 
		query.append("                          AND     RT.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                          AND     RT.LOCL_CURR_CD = OFFICE.AR_CURR_CD" ).append("\n"); 
		query.append("                          AND     RT.CHG_CURR_CD ='USD'  and SVC_SCP_CD <> 'OTH'" ).append("\n"); 
		query.append("						  AND     RT.SVC_SCP_CD = BK.SVC_SCP_CD  ),'OTH')" ).append("\n"); 
		query.append("           ) RT" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO = PS.BKG_NO          -- ????" ).append("\n"); 
		query.append("AND     PS.BKG_CNTC_PSON_TP_CD = 'BK'  -- ????" ).append("\n"); 
		query.append("AND     CUST.CUST_CNT_CD = CUSTOMER.CUST_CNT_CD" ).append("\n"); 
		query.append("AND     CUST.CUST_SEQ = CUSTOMER.CUST_SEQ" ).append("\n"); 
		query.append("-- AND     NVL(CUSTOMER.CUST_NAMED_FLAG,'N') <> 'Y' " ).append("\n"); 
		query.append("AND     BK.BKG_NO = CNTR.BKG_NO(+) " ).append("\n"); 
		query.append("AND     BK.VSL_CD = VSL.VSL_CD " ).append("\n"); 
		query.append("--AND     BK.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("--AND     BK.SKD_VOY_NO = SKD.SKD_VOY_NO " ).append("\n"); 
		query.append("--AND     BK.SKD_DIR_CD = SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("AND     BK.BKG_OFC_CD = OFFICE.OFC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND     RT.PORT_CD = BK.POR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BK.VSL_CD = RT.VSL_CD(+)" ).append("\n"); 
		query.append("AND     BK.SKD_VOY_NO = RT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     BK.SKD_DIR_CD = RT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     BK.POL_CD     = RT.PORT_CD(+)" ).append("\n"); 
		query.append("AND     BK.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND     BK.POL_CD = POL.LOC_CD " ).append("\n"); 
		query.append("--AND     BK.POD_CD = POD.LOC_CD " ).append("\n"); 
		query.append("--AND     BK.DEL_CD = DEL.LOC_CD " ).append("\n"); 
		query.append("AND     BK.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("AND     BV.POL_CD =  SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     BV.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("AND     BV.SKD_VOY_NO = SKD.SKD_VOY_NO  " ).append("\n"); 
		query.append("AND     BV.SKD_DIR_CD = SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("AND     BK.BKG_STS_CD IN ('F','S','W') " ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append(" AND	BV.VSL_CD         =   SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(" AND    BV.SKD_VOY_NO     =   SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append(" AND    BV.SKD_DIR_CD     =   SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND     BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND     BV.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND     BK.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("AND		BK.BKG_OFC_CD   = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} != '') " ).append("\n"); 
		query.append("AND		CUST.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("AND		CUST.CUST_CNT_CD	= @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '') " ).append("\n"); 
		query.append("AND		CUST.CUST_SEQ		= @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} == 'VL') " ).append("\n"); 
		query.append("AND		CNTR.CNMV_STS_CD	= 'VL'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND    BK.BKG_NO IN ('HAMY3239204','HAMY3200027')" ).append("\n"); 
		query.append("ORDER BY 'Pol : '|| BK.POL_CD  || '	/	' || 'Shipper : ' || NVL(CUST.CUST_CNT_CD,' ')||' '||NVL(TO_CHAR(CUST.CUST_SEQ),' ')||'/'||TRANSLATE(NVL(SUBSTR(CUSTOMER.CUST_LGL_ENG_NM,1,15),' '),CHR(13)||CHR(10),' ')   || '	Exchange Rate : 1 USD '  || TRIM(TO_CHAR(ROUND(DECODE(OFFICE.AR_CURR_CD,'GBP',1/RT.INV_XCH_RT,NVL(INV_XCH_RT,0)),4),'9999999999.9999')) || ' ' || NVL(RT.LOCL_CURR_CD,' ')  || '\\\\\\\\\\\\\\\\tBooking No : ' || BK.BKG_NO " ).append("\n"); 
		query.append(",       CNTR.CNTR_NO" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}