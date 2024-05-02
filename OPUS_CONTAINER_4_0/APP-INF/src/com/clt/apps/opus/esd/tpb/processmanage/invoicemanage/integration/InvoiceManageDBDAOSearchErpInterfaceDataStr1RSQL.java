/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataStr1
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchErpInterfaceDataStr1RSQL").append("\n"); 
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
		query.append("SELECT LPAD(TO_CHAR(TPB_INV_IF_SMRY_SEQ1.NEXTVAL),10,'0') AS AR_IF_NO" ).append("\n"); 
		query.append("      ,SUBSTRB(HDR.N3PTY_INV_NO,1,11)||DECODE(SUBSTRB(HDR.N3PTY_INV_RVIS_CD,1,1),'O',HDR.N3PTY_INV_RVIS_CD,'R',HDR.N3PTY_INV_RVIS_CD,'') AS N3PTY_INV_NO" ).append("\n"); 
		query.append("      ,HDR.IF_BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,NVL(DTL.BKG_NO,'') AS BKG_NO" ).append("\n"); 
		query.append("      ,NULL AS IF_RHQ_CD /* appoint to send null value */" ).append("\n"); 
		query.append("      ,INV.OFC_CD AS IF_OFC_CD" ).append("\n"); 
		query.append("      ,@[user_ofc_cd] USER_OFC_CD" ).append("\n"); 
		query.append("      ,@[user_id] USER_ID" ).append("\n"); 
		query.append("      ,DECODE( HDR.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("              'C', HDR.CUST_CNT_CD," ).append("\n"); 
		query.append("              NVL((" ).append("\n"); 
		query.append("                     SELECT SUBSTRB(V.RFND_PSDO_CUST_CD,1,2)" ).append("\n"); 
		query.append("                       FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                      WHERE 1 = 1" ).append("\n"); 
		query.append("                        AND V.VNDR_SEQ = HDR.VNDR_SEQ" ).append("\n"); 
		query.append("                        AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND V.RFND_PSDO_CUST_CD IS NOT NULL" ).append("\n"); 
		query.append("                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("               , NULL)" ).append("\n"); 
		query.append("       ) INV_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,DECODE( HDR.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("              'C', HDR.CUST_SEQ," ).append("\n"); 
		query.append("              NVL((" ).append("\n"); 
		query.append("                     SELECT SUBSTRB(V.RFND_PSDO_CUST_CD,3,LENGTHB(V.RFND_PSDO_CUST_CD))" ).append("\n"); 
		query.append("                       FROM MDM_VENDOR V" ).append("\n"); 
		query.append("                      WHERE 1 = 1" ).append("\n"); 
		query.append("                        AND V.VNDR_SEQ = HDR.VNDR_SEQ" ).append("\n"); 
		query.append("                        AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                        AND V.RFND_PSDO_CUST_CD IS NOT NULL" ).append("\n"); 
		query.append("                        AND ROWNUM = 1)" ).append("\n"); 
		query.append("            , NULL)" ).append("\n"); 
		query.append("       ) INV_CUST_SEQ" ).append("\n"); 
		query.append("      ,DECODE(OTS.N3PTY_EXPN_TP_CD,'MNR','CNTC',                   DECODE((SELECT COUNT(1) FROM AR_MST_REV_VVD WHERE VSL_CD = DTL.VSL_CD AND SKD_VOY_NO = DTL.SKD_VOY_NO AND SKD_DIR_CD = SUBSTR(DTL.FINC_DIR_CD,1,1) AND DELT_FLG = 'N'),0,'CNTC',DTL.VSL_CD)) AS VSL_CD" ).append("\n"); 
		query.append("      ,DECODE(OTS.N3PTY_EXPN_TP_CD,'MNR',TO_CHAR(SYSDATE,'YYMM'),  DECODE((SELECT COUNT(1) FROM AR_MST_REV_VVD WHERE VSL_CD = DTL.VSL_CD AND SKD_VOY_NO = DTL.SKD_VOY_NO AND SKD_DIR_CD = SUBSTR(DTL.FINC_DIR_CD,1,1) AND DELT_FLG = 'N'),0,TO_CHAR(SYSDATE,'YYMM'),DTL.SKD_VOY_NO)) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,DECODE(OTS.N3PTY_EXPN_TP_CD,'MNR','MM',                     DECODE((SELECT COUNT(1) FROM AR_MST_REV_VVD WHERE VSL_CD = DTL.VSL_CD AND SKD_VOY_NO = DTL.SKD_VOY_NO AND SKD_DIR_CD = SUBSTR(DTL.FINC_DIR_CD,1,1) AND DELT_FLG = 'N'),0,'MM',DTL.FINC_DIR_CD)) AS FINC_DIR_CD" ).append("\n"); 
		query.append("--    ,DECODE(dtl.vsl_cd, 'HJZZ', 'CNTC',                  DECODE( ots.n3pty_expn_tp_cd, 'MNR','CNTC',                  DECODE(LENGTHB(dtl.vsl_cd||dtl.skd_voy_no||dtl.finc_dir_cd), 10,dtl.vsl_cd,      'CNTC'                 ) ) ) As vsl_cd       /* HJZZ => COMMON VVD ... BY Kim Jin-seung In 2008-04-28 */" ).append("\n"); 
		query.append("--    ,DECODE(dtl.vsl_cd, 'HJZZ', TO_CHAR(SYSDATE,'YYMM'), DECODE( ots.n3pty_expn_tp_cd, 'MNR',TO_CHAR(SYSDATE,'YYMM'), DECODE(LENGTHB(dtl.vsl_cd||dtl.skd_voy_no||dtl.finc_dir_cd), 10,dtl.skd_voy_no,  TO_CHAR(SYSDATE,'YYMM')) ) ) As skd_voy_no   /* HJZZ => COMMON VVD ... BY Kim Jin-seung In 2008-04-28 */" ).append("\n"); 
		query.append("--    ,DECODE(dtl.vsl_cd, 'HJZZ', 'MM',                    DECODE( ots.n3pty_expn_tp_cd, 'MNR','MM',                    DECODE(LENGTHB(dtl.vsl_cd||dtl.skd_voy_no||dtl.finc_dir_cd), 10,dtl.finc_dir_cd, 'MM'                   ) ) ) As finc_dir_cd  /* HJZZ => COMMON VVD ... BY Kim Jin-seung In 2008-04-28 */" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE,'YYYYMMDD') AS SAIL_ARR_DT" ).append("\n"); 
		query.append("      ,( SELECT LOC_CD FROM MDM_ORGANIZATION Z WHERE Z.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS POR_CD" ).append("\n"); 
		query.append("      ,( SELECT LOC_CD FROM MDM_ORGANIZATION Z WHERE Z.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS POL_CD" ).append("\n"); 
		query.append("      ,( SELECT LOC_CD FROM MDM_ORGANIZATION Z WHERE Z.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS POD_CD" ).append("\n"); 
		query.append("      ,( SELECT LOC_CD FROM MDM_ORGANIZATION Z WHERE Z.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS DEL_CD" ).append("\n"); 
		query.append("--      ,'RBC' AS LANE_CD" ).append("\n"); 
		query.append("	  ,NVL((SELECT SLAN_CD FROM VSK_VSL_PORT_SKD WHERE VSL_CD = DTL.VSL_CD AND SKD_VOY_NO = DTL.SKD_VOY_NO AND SKD_DIR_CD = SUBSTR(DTL.FINC_DIR_CD,1,1) AND ROWNUM = 1),'RBC') AS LANE_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(SIGN(HDR.RCV_DUE_DT-(SYSDATE+15)),1,HDR.RCV_DUE_DT,SYSDATE+15),'YYYYMMDD') AS RCV_DUE_DT" ).append("\n"); 
		query.append("      ,DECODE( DECODE( HDR.CURR_CD,'USD','F','T' ) || DECODE( (SELECT AR_CURR_CD FROM MDM_ORGANIZATION MM WHERE MM.OFC_CD=INV.OFC_CD AND ROWNUM=1),'USD','T','F' )," ).append("\n"); 
		query.append("              'FF', HDR.INV_AMT,0) AS INV_IF_USD_AMT" ).append("\n"); 
		query.append("      ,DECODE( DECODE( HDR.CURR_CD,'USD','F','T' ) || DECODE( (SELECT AR_CURR_CD FROM MDM_ORGANIZATION MM WHERE MM.OFC_CD=INV.OFC_CD AND ROWNUM=1),'USD','T','F' )," ).append("\n"); 
		query.append("              'FF', 0,HDR.INV_AMT) AS INV_IF_LOCL_AMT" ).append("\n"); 
		query.append("      ,DECODE( SUBSTRB(HDR.INV_DESC,1,200), NULL, '-', SUBSTRB(HDR.INV_DESC,1,200) ) AS INV_IF_DESC" ).append("\n"); 
		query.append("      ,( SELECT LOC_CD FROM MDM_ORGANIZATION Z WHERE Z.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS INV_IF_CTY_CD" ).append("\n"); 
		query.append("      ,( SELECT AR_CURR_CD FROM MDM_ORGANIZATION MM WHERE MM.OFC_CD=INV.OFC_CD AND ROWNUM=1 ) AS CURR_CD" ).append("\n"); 
		query.append("      ,NULL AS INV_IF_FLG" ).append("\n"); 
		query.append("      ,NULL AS INV_IF_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS INV_IF_DT" ).append("\n"); 
		query.append("      ,INV.OFC_CD AS INV_IF_OFC_CD" ).append("\n"); 
		query.append("      ,NULL AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("      ,NULL AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("      ,TPB_GET_USD_XCH_RT_FNC(HDR.CURR_CD, NVL(TPB_GET_LCL_DATE_FNC(SYSDATE,INV.OFC_CD),SYSDATE)) AS MON_XCH_RT    /* added in 2007-03-22 TPB LOCAL DATE */" ).append("\n"); 
		query.append("      ,DTL.CSR_NO" ).append("\n"); 
		query.append("      ,DTL.VVD_CD" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("          SELECT NVL2(S.GL_DT," ).append("\n"); 
		query.append("	                  DECODE(NVL((SELECT CLZ_STS_CD STS FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND EFF_YRMON=SUBSTRB(S.GL_DT,1,6) AND OFC_CD=(SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD=INV.OFC_CD AND ROWNUM=1) AND ROWNUM=1),(SELECT CLZ_STS_CD STS FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND EFF_YRMON=SUBSTRB(S.GL_DT,1,6) AND OFC_CD=TPB_GET_HNDL_OFC_FNC('R',INV.OFC_CD) AND ROWNUM=1))," ).append("\n"); 
		query.append("	                         'O', GL_DT," ).append("\n"); 
		query.append("	                         'C', NVL((SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=(SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD=INV.OFC_CD AND ROWNUM=1)),(SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=TPB_GET_HNDL_OFC_FNC('R',INV.OFC_CD)))||'01'," ).append("\n"); 
		query.append("	                         NVL((SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=(SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD=INV.OFC_CD AND ROWNUM=1)),(SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=TPB_GET_HNDL_OFC_FNC('R',INV.OFC_CD)))||'01')," ).append("\n"); 
		query.append("	                         NVL((SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=(SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD=INV.OFC_CD AND ROWNUM=1)),(SELECT MIN(EFF_YRMON) DT FROM AP_PERIOD WHERE SYS_DIV_CD='14' AND CLZ_STS_CD='O' AND OFC_CD=TPB_GET_HNDL_OFC_FNC('R',INV.OFC_CD)))||'01') AS GL_DT" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT --- Billing case" ).append("\n"); 
		query.append("                           DECODE( MAX(Z.N3PTY_BIL_TP_CD)," ).append("\n"); 
		query.append("                           'JO', DECODE( COUNT( DISTINCT NVL(Z.GL_DT,'-') ), 1, MAX(Z.GL_DT), MAX( SUBSTRB(Z.GL_DT,1,6) ) || '01' )," ).append("\n"); 
		query.append("                           NULL) GL_DT" ).append("\n"); 
		query.append("                      FROM TPB_OTS_GRP A, TPB_INVOICE X, TPB_INV_RVIS Y, TPB_INV_RVIS_DTL Z" ).append("\n"); 
		query.append("                     WHERE X.N3PTY_INV_NO = Y.N3PTY_INV_NO" ).append("\n"); 
		query.append("                       AND X.N3PTY_INV_NO = Z.N3PTY_INV_NO" ).append("\n"); 
		query.append("                       AND X.N3PTY_INV_NO = A.N3PTY_INV_NO" ).append("\n"); 
		query.append("                       AND Y.N3PTY_INV_RVIS_SEQ = Z.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("                       AND Z.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("                       AND A.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("                       AND X.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("                       AND Y.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("                       AND Z.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("                       AND Y.N3PTY_INV_NO = @[s_n3pty_inv_no]                /* bind varialbe */" ).append("\n"); 
		query.append("                       AND Y.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]     /* bind varialbe */" ).append("\n"); 
		query.append("                 ) S" ).append("\n"); 
		query.append("           WHERE 1 = 1" ).append("\n"); 
		query.append("       ) AS GL_DT" ).append("\n"); 
		query.append("      ,HDR.VNDR_CUST_REF_RMK, DTL.EQ_NO AS TRF_NO" ).append("\n"); 
		query.append("  FROM TPB_OTS_GRP OTS, TPB_INVOICE INV, TPB_INV_RVIS HDR, TPB_INV_RVIS_DTL DTL" ).append("\n"); 
		query.append(" WHERE INV.N3PTY_INV_NO = HDR.N3PTY_INV_NO" ).append("\n"); 
		query.append("   AND INV.N3PTY_INV_NO = DTL.N3PTY_INV_NO" ).append("\n"); 
		query.append("   AND INV.N3PTY_INV_NO = OTS.N3PTY_INV_NO" ).append("\n"); 
		query.append("   AND HDR.N3PTY_INV_RVIS_SEQ = DTL.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("   AND DTL.N3PTY_NO = OTS.N3PTY_NO" ).append("\n"); 
		query.append("   AND OTS.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND INV.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND HDR.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND DTL.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("   AND HDR.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("   AND HDR.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("   AND DTL.N3PTY_INV_RVIS_DTL_SEQ = 1                          /* 한 행만... */" ).append("\n"); 

	}
}