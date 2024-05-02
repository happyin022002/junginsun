/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationBC::searchChargeListByPodEta
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeListByPodEtaRSQL").append("\n"); 
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
		query.append("#if (${cond_type} == 'vvd_cd')" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD		= SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     CO_IND_CD	= 'H'" ).append("\n"); 
		query.append(") SVR_ID" ).append("\n"); 
		query.append(",BCN.CNTR_NO" ).append("\n"); 
		query.append(",BCN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BK.BKG_NO" ).append("\n"); 
		query.append(",BK.BL_NO" ).append("\n"); 
		query.append(",BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(",BV.SLAN_CD     AS LANE" ).append("\n"); 
		query.append(",BK.POR_CD  	AS POR_CD" ).append("\n"); 
		query.append(",BK.POL_CD   	AS POL_CD" ).append("\n"); 
		query.append(",BK.POD_CD   	AS POD_CD" ).append("\n"); 
		query.append(",BK.DEL_CD  	AS DEL_CD" ).append("\n"); 
		query.append(",BK.RCV_TERM_CD AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BK.DE_TERM_CD  AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",BK.SC_NO" ).append("\n"); 
		query.append(",BK.RFA_NO" ).append("\n"); 
		query.append(",BK.POD_NOD_CD 	AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append(",BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST" ).append("\n"); 
		query.append("--        ,BCN.CNMV_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",CASE WHEN BCN.CNMV_CYC_NO != 9999 THEN BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("ELSE ( SELECT MAX(CNMV_CYC_NO) FROM CTM_MOVEMENT WHERE CNTR_NO = BCN.CNTR_NO AND BKG_NO = BCN.BKG_NO )" ).append("\n"); 
		query.append("END AS CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BCS.CUST_CNT_CD || TRIM(TO_CHAR(BCS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append(",REPLACE(BCS.CUST_NM, CHR(13)||CHR(10),' ') SHIPPER_NM" ).append("\n"); 
		query.append(",DECODE(BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000')), '000000', NULL, BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append(",REPLACE(BCC.CUST_NM, CHR(13)||CHR(10),' ') CNEE_NM" ).append("\n"); 
		query.append(",DECODE(BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000')), '000000', NULL, BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append(",NVL(RTRIM(REPLACE(REPLACE(BCCN.CUST_NM, '\"', ''), CHR(13)||CHR(10),' ')),'-') NTFY_NM" ).append("\n"); 
		query.append(",(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("FROM    INV_AR_MN I" ).append("\n"); 
		query.append("WHERE   I.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND     I.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_CD" ).append("\n"); 
		query.append(",(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND		I.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		I.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_NM" ).append("\n"); 
		query.append(", ( SELECT  COUNT(*)" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC	C," ).append("\n"); 
		query.append("COM_SYS_AREA_GRP_ID  S" ).append("\n"); 
		query.append("WHERE   C.SYS_AREA_GRP_ID		=	S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		C.CNTR_NO		=   BCN.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO	=   BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD	IN	('DMIF', 'CTIC')" ).append("\n"); 
		query.append("AND     S.CNT_CD		=	SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     S.CO_IND_CD		=	'H'" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("FROM     BKG_BOOKING     BK," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCS," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCC," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCCN," ).append("\n"); 
		query.append("BKG_CONTAINER   BCN," ).append("\n"); 
		query.append("BKG_VVD         BV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO          = BCN.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCS.BKG_NO" ).append("\n"); 
		query.append("AND  BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCC.BKG_NO" ).append("\n"); 
		query.append("AND  BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCCN.BKG_NO" ).append("\n"); 
		query.append("AND  BCCN.BKG_CUST_TP_CD= 'N'" ).append("\n"); 
		query.append("AND  BK.DE_TERM_CD  	<>  'T'" ).append("\n"); 
		query.append("AND  BK.BKG_STS_CD  	NOT IN ('S', 'X')" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BV.BKG_NO" ).append("\n"); 
		query.append("AND  BV.VSL_CD          = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND  BV.SKD_VOY_NO      = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND  BV.SKD_DIR_CD      = SUBSTR(@[vvd_cd],9)" ).append("\n"); 
		query.append("AND  BK.POD_CD       	= @[pod_cd]" ).append("\n"); 
		query.append("AND  BK.BKG_CGO_TP_CD   =   'F'" ).append("\n"); 
		query.append("AND  BCN.DE_TERM_CD IN	('D', 'H', 'O', 'M', 'Y')" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.CNT = 0" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD		= SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     CO_IND_CD	= 'H'" ).append("\n"); 
		query.append(") SVR_ID" ).append("\n"); 
		query.append(",BCN.CNTR_NO" ).append("\n"); 
		query.append(",BCN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BK.BKG_NO" ).append("\n"); 
		query.append(",BK.BL_NO" ).append("\n"); 
		query.append(",BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(",BV.SLAN_CD     AS LANE" ).append("\n"); 
		query.append(",BK.POR_CD  	AS POR_CD" ).append("\n"); 
		query.append(",BK.POL_CD   	AS POL_CD" ).append("\n"); 
		query.append(",BK.POD_CD   	AS POD_CD" ).append("\n"); 
		query.append(",BK.DEL_CD  	AS DEL_CD" ).append("\n"); 
		query.append(",BK.RCV_TERM_CD AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BK.DE_TERM_CD  AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",BK.SC_NO" ).append("\n"); 
		query.append(",BK.RFA_NO" ).append("\n"); 
		query.append(",BK.POD_NOD_CD	AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append(",BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST" ).append("\n"); 
		query.append("--        ,BCN.CNMV_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",CASE WHEN BCN.CNMV_CYC_NO != 9999 THEN BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("ELSE ( SELECT MAX(CNMV_CYC_NO) FROM CTM_MOVEMENT WHERE CNTR_NO = BCN.CNTR_NO AND BKG_NO = BCN.BKG_NO )" ).append("\n"); 
		query.append("END AS CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BCS.CUST_CNT_CD || TRIM(TO_CHAR(BCS.CUST_SEQ, '000000')) SHIPPER_CD" ).append("\n"); 
		query.append(",REPLACE(BCS.CUST_NM, CHR(13)||CHR(10),' ') SHIPPER_NM" ).append("\n"); 
		query.append(",DECODE(BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000')), '000000', NULL, BCC.CUST_CNT_CD || TRIM(TO_CHAR(BCC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append(",REPLACE(BCC.CUST_NM, CHR(13)||CHR(10),' ') CNEE_NM" ).append("\n"); 
		query.append(",DECODE(BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000')), '000000', NULL, BCCN.CUST_CNT_CD || TRIM(TO_CHAR(BCCN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append(",NVL(RTRIM(REPLACE(REPLACE(BCCN.CUST_NM, '\"', ''), CHR(13)||CHR(10),' ')),'-') NTFY_NM" ).append("\n"); 
		query.append(",(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("FROM    INV_AR_MN I" ).append("\n"); 
		query.append("WHERE   I.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND     I.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_CD" ).append("\n"); 
		query.append(",(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND		I.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		I.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("SELECT	MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM	INV_AR_MN" ).append("\n"); 
		query.append("WHERE	BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND		IO_BND_CD = 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND		ROWNUM  = 1" ).append("\n"); 
		query.append(") AS AR_ACT_NM" ).append("\n"); 
		query.append(", ( SELECT  COUNT(*)" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC	C," ).append("\n"); 
		query.append("COM_SYS_AREA_GRP_ID  S" ).append("\n"); 
		query.append("WHERE   C.SYS_AREA_GRP_ID		=	S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		C.CNTR_NO		=   BCN.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO	=   BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD	IN	('DMIF', 'CTIC')" ).append("\n"); 
		query.append("AND     S.CNT_CD		=	SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     S.CO_IND_CD		=	'H'" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("FROM     BKG_BOOKING     BK," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCS," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCC," ).append("\n"); 
		query.append("BKG_CUSTOMER    BCCN," ).append("\n"); 
		query.append("BKG_CONTAINER   BCN," ).append("\n"); 
		query.append("BKG_VVD   		 BV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO          = BCN.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCS.BKG_NO" ).append("\n"); 
		query.append("AND  BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCC.BKG_NO" ).append("\n"); 
		query.append("AND  BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BCCN.BKG_NO" ).append("\n"); 
		query.append("AND  BCCN.BKG_CUST_TP_CD= 'N'" ).append("\n"); 
		query.append("AND  BK.BKG_NO          = BV.BKG_NO" ).append("\n"); 
		query.append("AND  BK.POD_CD          = BV.POD_CD" ).append("\n"); 
		query.append("AND  BK.DE_TERM_CD  	<>  'T'" ).append("\n"); 
		query.append("AND  BK.BKG_STS_CD  	NOT IN ('S', 'X')" ).append("\n"); 
		query.append("AND  BK.BKG_CGO_TP_CD   =   'F'" ).append("\n"); 
		query.append("AND  BCN.DE_TERM_CD IN	('D', 'H', 'O', 'M', 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND BK.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND BK.BL_NO IN (" ).append("\n"); 
		query.append("#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.CNT = 0" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bypodeta} == 'booking')" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD		= SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     CO_IND_CD	= 'H'" ).append("\n"); 
		query.append(") SVR_ID" ).append("\n"); 
		query.append(",BCN.CNTR_NO" ).append("\n"); 
		query.append(",BCN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--            ,BCN.CNMV_CYC_NO AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",CASE WHEN BCN.CNMV_CYC_NO != 9999 THEN BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("ELSE ( SELECT MAX(CNMV_CYC_NO) FROM CTM_MOVEMENT WHERE CNTR_NO = BCN.CNTR_NO AND BKG_NO = BCN.BKG_NO )" ).append("\n"); 
		query.append("END AS CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BK.POD_NOD_CD AS FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",(	SELECT  COUNT(*)" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC	C," ).append("\n"); 
		query.append("COM_SYS_AREA_GRP_ID  S" ).append("\n"); 
		query.append("WHERE   C.SYS_AREA_GRP_ID		=	S.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		C.CNTR_NO		=   BCN.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO	=   BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD	IN	('DMIF', 'CTIC')" ).append("\n"); 
		query.append("AND     S.CNT_CD		=	SUBSTR(BK.POD_CD, 1, 2)" ).append("\n"); 
		query.append("AND     S.CO_IND_CD		=	'H'" ).append("\n"); 
		query.append(") CNT" ).append("\n"); 
		query.append("FROM     BKG_BOOKING    BK," ).append("\n"); 
		query.append("BKG_CONTAINER  BCN," ).append("\n"); 
		query.append("BKG_VVD        BV" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BK.BKG_NO  = BCN.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO  = BV.BKG_NO" ).append("\n"); 
		query.append("AND  BK.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND  BV.POD_CD  = BK.POD_CD" ).append("\n"); 
		query.append("AND  BK.DE_TERM_CD		<>	'T'" ).append("\n"); 
		query.append("AND  BK.BKG_STS_CD		NOT IN ('S', 'X')" ).append("\n"); 
		query.append("AND  BK.BKG_CGO_TP_CD	=	'F'" ).append("\n"); 
		query.append("AND  BCN.DE_TERM_CD IN	('D', 'H', 'O', 'M', 'Y')" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.CNT = 0" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}