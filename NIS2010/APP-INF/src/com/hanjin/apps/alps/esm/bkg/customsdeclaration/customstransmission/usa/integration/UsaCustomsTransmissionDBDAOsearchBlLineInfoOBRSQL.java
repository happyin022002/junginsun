/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBlLineInfoOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBlLineInfoOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchBlLineInfoOBRSQL
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBlLineInfoOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_first_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBlLineInfoOBRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		B01," ).append("\n"); 
		query.append("		B01ISF5," ).append("\n"); 
		query.append("		IT_ITNO," ).append("\n"); 
		query.append("		IT_ITTYPE,		 " ).append("\n"); 
		query.append("		IT_DEL," ).append("\n"); 
		query.append("		WGT_VAL," ).append("\n"); 
		query.append("		IT_PKG_QTY," ).append("\n"); 
		query.append("		IT_PKG_AMS," ).append("\n"); 
		query.append("		IT_IPI_LOCAL," ).append("\n"); 
		query.append("		CMDT_CD," ).append("\n"); 
		query.append("		AMS_CODE," ).append("\n"); 
		query.append("		B02," ).append("\n"); 
		query.append("		B04," ).append("\n"); 
		query.append("		B04_2," ).append("\n"); 
		query.append("		B04ISF5," ).append("\n"); 
		query.append("		MF_NO," ).append("\n"); 
		query.append("		BL_NO," ).append("\n"); 
		query.append("		ACT_FILE_SKD_DIR_CD," ).append("\n"); 
		query.append("        FPOD_CD," ).append("\n"); 
		query.append("        BOOKING_POD_CD," ).append("\n"); 
		query.append("		MF_STS_CD," ).append("\n"); 
		query.append("		CSTMS_LOC_CD" ).append("\n"); 
		query.append("	FROM(	" ).append("\n"); 
		query.append("		SELECT RPAD(" ).append("\n"); 
		query.append("		            'B01'||" ).append("\n"); 
		query.append("		            RPAD(IT.BL_NO, 12, ' ')||" ).append("\n"); 
		query.append("		            LOC.LOC_AMS_PORT_CD||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            RPAD(NVL(IT.AMS_PCK_TP_CD,'PKGS'),5,' ')||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.CGO_WGT,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            NVL(SUBSTR(IT.WGT_UT_CD, 1, 2),'KG')||" ).append("\n"); 
		query.append("                    'M' ,80,' ')|| CHR(10) B01," ).append("\n"); 
		query.append("		       '' B01ISF5,              " ).append("\n"); 
		query.append("		       '' IT_ITNO, -- " ).append("\n"); 
		query.append("		       '' IT_ITTYPE, -- 61,62,63" ).append("\n"); 
		query.append("		       NVL(IT.HUB_LOC_CD,' ') IT_HUB," ).append("\n"); 
		query.append("		       NVL(IT.DEL_CD,' ') IT_DEL," ).append("\n"); 
		query.append("		       SUBSTR(TO_CHAR(IT.CGO_WGT*20,'09999999'),2) WGT_VAL," ).append("\n"); 
		query.append("		       SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2) IT_PKG_QTY," ).append("\n"); 
		query.append("		       NVL(IT.AMS_PCK_TP_CD,'PKG  ') IT_PKG_AMS," ).append("\n"); 
		query.append("		       '' IT_IPI_LOCAL," ).append("\n"); 
		query.append("		       NVL(IT.CMDT_CD,' ') CMDT_CD," ).append("\n"); 
		query.append("		       '' AMS_CODE," ).append("\n"); 
		query.append("		       RPAD(" ).append("\n"); 
		query.append("		            'B02'||" ).append("\n"); 
		query.append("		            '          '||" ).append("\n"); 
		query.append("		            '  '||" ).append("\n"); 
		query.append("		            NVL(SUBSTR(LOC4.LOC_NM||'                 ',1,17),'                 ')" ).append("\n"); 
		query.append("		            ||'            '||" ).append("\n"); 
		query.append("		            DECODE(NVL(IT.MF_NO, ' '), " ).append("\n"); 
		query.append("		                  ' ', " ).append("\n"); 
		query.append("					(SELECT  NVL( MAX(  DECODE ( ATTR_CTNT2, 'ALL', ATTR_CTNT3, IT.CSTMS_POD_CD, ATTR_CTNT3  )   ) , '    ')" ).append("\n"); 
		query.append("					FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("					WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("					AND CSTMS_DIV_ID = 'SC_FIRMS_CD_MAP'" ).append("\n"); 
		query.append("					AND ATTR_CTNT1 = IT.SC_NO" ).append("\n"); 
		query.append("					AND DELT_FLG = 'N' ), 'SMLM'" ).append("\n"); 
		query.append("                       )||" ).append("\n"); 
		query.append("						(SELECT  NVL( MAX(  DECODE ( ATTR_CTNT1,  IT.POD_NOD_CD  , ATTR_CTNT2  )   ) , '    ')" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                            AND CSTMS_DIV_ID = 'LOC_FIRMS_CD_MAP'" ).append("\n"); 
		query.append("							AND DELT_FLG = 'N' )" ).append("\n"); 
		query.append("						||" ).append("\n"); 
		query.append("		           @[pol_first_loc]" ).append("\n"); 
		query.append("		       ,80,' ')||CHR(10) B02," ).append("\n"); 
		query.append("		       RPAD('B04'||'OB SMLM'||IT.MF_NO,80,' ')||CHR(10) B04," ).append("\n"); 
		query.append("		       RPAD('B04'||'OL SMLM'||IT.PRE_MF_NO,80,' ')||CHR(10) B04_2," ).append("\n"); 
		query.append("			   RPAD('B04'||'CSK'||DECODE(substr(IT.POD_CD,1,2), 'US', LOC6.LOC_AMS_PORT_CD, LOC5.LOC_AMS_PORT_CD),80,' ')||CHR(10)||RPAD('B04'||'CSK'||LOC6.LOC_AMS_PORT_CD,80,' ')||CHR(10) B04ISF5," ).append("\n"); 
		query.append("			   RPAD(IT.BL_NO, 12, ' ') BL_NO," ).append("\n"); 
		query.append("			   NVL(IT.MF_NO, 'X') MF_NO," ).append("\n"); 
		query.append("			   ACT_FILE_SKD_DIR_CD," ).append("\n"); 
		query.append("               IT.POD_CD FPOD_CD," ).append("\n"); 
		query.append("               IT.POD_CD BOOKING_POD_CD," ).append("\n"); 
		query.append("			   IT.MF_STS_CD," ).append("\n"); 
		query.append("			   IT.CSTMS_LOC_CD" ).append("\n"); 
		query.append("		  FROM MDM_LOCATION  LOC, MDM_LOCATION LOC4, MDM_LOCATION LOC5, MDM_LOCATION LOC6, " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT BKG.CMDT_CD" ).append("\n"); 
		query.append("                  ,BKG.SC_NO" ).append("\n"); 
		query.append("                  ,VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("                  ,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("                  ,BKG.VSL_CD" ).append("\n"); 
		query.append("                  ,NVL(BKG.USA_CSTMS_FILE_CD,'3') AS CSTMS_FILE_TP_CD " ).append("\n"); 
		query.append("                  ,'N' FROB_FLG " ).append("\n"); 
		query.append("                  , ( SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = DECODE(BKG.BKG_CRE_TP_CD, 'S', BKG.FM_BKG_NO, NULL)) PRE_MF_NO" ).append("\n"); 
		query.append("                  ,BKG.BL_NO " ).append("\n"); 
		query.append("                  ,BKG.POL_CD" ).append("\n"); 
		query.append("                  ,NVL(P.USA_CSTMS_PCK_CD,'PKG') AS AMS_PCK_TP_CD" ).append("\n"); 
		query.append("                  ,NVL(D.WGT_UT_CD,'KGS') AS WGT_UT_CD" ).append("\n"); 
		query.append("                  ,VVD.POD_CD CSTMS_POD_CD" ).append("\n"); 
		query.append("                  ,BKG.UPD_USR_ID" ).append("\n"); 
		query.append("                   ,(SELECT SUBSTR( MIN( LPAD(CLPT_SEQ, 2, 0) ||VPS_PORT_CD) , 3)" ).append("\n"); 
		query.append("                                FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                               WHERE 1=1" ).append("\n"); 
		query.append("                                 AND	SUBSTR(VPS_PORT_CD,1,2)	IN('US', (SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("                                                                                                WHERE CNT_cD='US'" ).append("\n"); 
		query.append("                                                                                                AND CSTMS_DIV_ID= 'US_CNT_CD_LIST') " ).append("\n"); 
		query.append("                                                                                    )                             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 AND VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                 AND SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND CLPT_IND_SEQ = '1' ) CSTMS_PORT_CD" ).append("\n"); 
		query.append("                   ,D.ACT_WGT AS CGO_WGT" ).append("\n"); 
		query.append("                   ,CASE WHEN BKG.POD_CD = BKG.DEL_CD THEN BKG.POD_CD ELSE '' END CSTMS_LOC_CD" ).append("\n"); 
		query.append("                   , SYSDATE AMDT_SND_DT" ).append("\n"); 
		query.append("                  ,BKG.DEL_CD" ).append("\n"); 
		query.append("                  ,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,BKG.POD_CD " ).append("\n"); 
		query.append("                  ,BKG.CRE_USR_ID" ).append("\n"); 
		query.append("                  ,BKG.BKG_NO" ).append("\n"); 
		query.append("                  ,BKG.BKG_CGO_TP_CD FULL_MTY_CD" ).append("\n"); 
		query.append("                   ,'' AS BDR_IF_USR_ID" ).append("\n"); 
		query.append("                  ,BKG.POR_CD" ).append("\n"); 
		query.append("                  ,VVD.POL_CD CSTMS_POL_CD" ).append("\n"); 
		query.append("                   ,'' AS MF_NO" ).append("\n"); 
		query.append("                   ,D.BDR_FLG     " ).append("\n"); 
		query.append("                  ,'A' MF_STS_CD " ).append("\n"); 
		query.append("                   ,SYSDATE MF_SND_DT " ).append("\n"); 
		query.append("                   ,D.MEAS_QTY      " ).append("\n"); 
		query.append("                   ,D.PCK_QTY" ).append("\n"); 
		query.append("                  ,TO_CHAR(D.BDR_DT,'YYYYMMDDHH24MISS') AS BDR_DTBDR_DT" ).append("\n"); 
		query.append("                  ,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("                   ,D.MEAS_UT_CD" ).append("\n"); 
		query.append("                  ,BKG.UPD_DT" ).append("\n"); 
		query.append("                  ,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("                  ,BKG.SLAN_CD" ).append("\n"); 
		query.append("                  ,'' HUB_LOC_CD" ).append("\n"); 
		query.append("                  ,'' ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM BKG_BOOKING BKG , BKG_VVD VVD , BKG_BL_DOC D,MDM_PCK_TP P" ).append("\n"); 
		query.append("             WHERE BKG.BKG_NO  in (SELECT COLUMN_VALUE BL_NO FROM TABLE(BKG_SPLIT_CLOB_FNC(${bl_no},',')) WHERE COLUMN_VALUE IS NOT NULL)" ).append("\n"); 
		query.append("                AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                AND BKG.BKG_NO     = D.BKG_NO(+)     " ).append("\n"); 
		query.append("                AND D.PCK_TP_CD  = P.PCK_CD(+)" ).append("\n"); 
		query.append("                AND VVD.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                AND VVD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                AND VVD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            ) IT" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   AND IT.CSTMS_POD_CD   = LOC.LOC_CD" ).append("\n"); 
		query.append("		   AND IT.POR_CD     	 = LOC4.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.CSTMS_POD_CD	 = LOC5.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.DEL_CD	 	 = LOC6.LOC_CD(+)" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}