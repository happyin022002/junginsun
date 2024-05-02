/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBlLineInfoRSQL.java
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

public class UsaCustomsTransmissionDBDAOsearchBlLineInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBlLineInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_last_ams",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBlLineInfoRSQL").append("\n"); 
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
		query.append("		IT_HUB," ).append("\n"); 
		query.append("		IT_LST_USA," ).append("\n"); 
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
		query.append("		MF_STS_CD" ).append("\n"); 
		query.append("		,CSTMS_LOC_CD" ).append("\n"); 
		query.append("	FROM(	" ).append("\n"); 
		query.append("		SELECT RPAD(" ).append("\n"); 
		query.append("		            'B01'||" ).append("\n"); 
		query.append("		            RPAD(IT.BL_NO, 12, ' ')||" ).append("\n"); 
		query.append("		            LOC.LOC_AMS_PORT_CD||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            RPAD(NVL(IT.AMS_PCK_TP_CD,'PKGS'),5,' ')||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.CGO_WGT,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            NVL(SUBSTR(IT.WGT_UT_CD, 1, 2),'KG')||" ).append("\n"); 
		query.append("                    DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                           'M', DECODE(IBD.CSTMS_CLR_TP_CD, 'F', 'B', 'V','B','2')," ).append("\n"); 
		query.append("                           DECODE(IBD.CSTMS_CLR_TP_CD," ).append("\n"); 
		query.append("                                  'F', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'B', 'O'), 'P')," ).append("\n"); 
		query.append("                                  'V', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'B', 'O'), 'P')," ).append("\n"); 
		query.append("                                  DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER', DECODE(IT.CSTMS_FILE_TP_CD, '3', '0', 'M'),  'N')" ).append("\n"); 
		query.append("                                         ))                                                          " ).append("\n"); 
		query.append("		       ,80,' ')|| CHR(10) B01," ).append("\n"); 
		query.append("		       RPAD(" ).append("\n"); 
		query.append("		            'B01'||" ).append("\n"); 
		query.append("		            RPAD(IT.BL_NO, 12, ' ')||" ).append("\n"); 
		query.append("		            LOC.LOC_AMS_PORT_CD||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            RPAD(NVL(IT.AMS_PCK_TP_CD,'PKGS'),5,' ')||" ).append("\n"); 
		query.append("		            SUBSTR(TO_CHAR(NVL(IT.CGO_WGT,0),'0999999999'),2)||" ).append("\n"); 
		query.append("		            NVL(SUBSTR(IT.WGT_UT_CD, 1, 2),'KG')||" ).append("\n"); 
		query.append("                    DECODE(IT.FULL_MTY_CD," ).append("\n"); 
		query.append("                               'M', DECODE(IBD.CSTMS_CLR_TP_CD, 'F', 'B', 'V','B','2')," ).append("\n"); 
		query.append("                               DECODE(IBD.CSTMS_CLR_TP_CD," ).append("\n"); 
		query.append("                                      'F', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'Q', 'Q'), 'R')," ).append("\n"); 
		query.append("                                      'V', DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER',DECODE(IT.CSTMS_FILE_TP_CD, '3', 'Q', 'Q'), 'R')," ).append("\n"); 
		query.append("                                      DECODE(NVL(IT.MF_NO, 'MASTER'), 'MASTER', DECODE(IT.CSTMS_FILE_TP_CD, '3', 'T', 'T'),  'S')" ).append("\n"); 
		query.append("                                             ))                         " ).append("\n"); 
		query.append("		       ,80,' ')|| CHR(10) B01ISF5," ).append("\n"); 
		query.append("		       NVL(IBD.IBD_TRSP_NO,' ') IT_ITNO, -- " ).append("\n"); 
		query.append("		       NVL(IBD.IBD_TRSP_TP_CD,'  ') IT_ITTYPE, -- 61,62,63" ).append("\n"); 
		query.append("		       NVL(IT.HUB_LOC_CD,' ') IT_HUB," ).append("\n"); 
		query.append("		       NVL(IT.USA_LST_LOC_CD,' ') IT_LST_USA," ).append("\n"); 
		query.append("		       NVL(IT.DEL_CD,' ') IT_DEL," ).append("\n"); 
		query.append("		       SUBSTR(TO_CHAR(IT.CGO_WGT*20,'09999999'),2) WGT_VAL," ).append("\n"); 
		query.append("		       SUBSTR(TO_CHAR(NVL(IT.PCK_QTY,0),'0999999999'),2) IT_PKG_QTY," ).append("\n"); 
		query.append("		       NVL(IT.AMS_PCK_TP_CD,'PKG  ') IT_PKG_AMS," ).append("\n"); 
		query.append("		       NVL(IBD.CSTMS_CLR_TP_CD,' ') IT_IPI_LOCAL," ).append("\n"); 
		query.append("		       NVL(BKG.CMDT_CD,' ') CMDT_CD," ).append("\n"); 
		query.append("		       DECODE(IBD.IBD_TRSP_TP_CD,'61',LOC3.LOC_AMS_PORT_CD,'62',LOC2.LOC_AMS_PORT_CD,'63',LOC2.LOC_AMS_PORT_CD,LOC3.LOC_AMS_PORT_CD) AMS_CODE," ).append("\n"); 
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
		query.append("					AND ATTR_CTNT1 = BKG.SC_NO" ).append("\n"); 
		query.append("					AND DELT_FLG = 'N' ), 'SMLM'" ).append("\n"); 
		query.append("                       )||" ).append("\n"); 
		query.append("						(SELECT  NVL( MAX(  DECODE ( ATTR_CTNT1,  IT.POD_NOD_CD  , ATTR_CTNT2  )   ) , '    ')" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("                            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                            AND CSTMS_DIV_ID = 'LOC_FIRMS_CD_MAP'" ).append("\n"); 
		query.append("							AND DELT_FLG = 'N' )" ).append("\n"); 
		query.append("						||" ).append("\n"); 
		query.append("		           @[pol_last_ams]" ).append("\n"); 
		query.append("		       ,80,' ')||CHR(10) B02," ).append("\n"); 
		query.append("		       RPAD('B04'||'OB SMLM'||IT.MF_NO,80,' ')||CHR(10) B04," ).append("\n"); 
		query.append("		       RPAD('B04'||'OL SMLM'||IT.PRE_MF_NO,80,' ')||CHR(10) B04_2," ).append("\n"); 
		query.append("			   RPAD('B04'||'CSK'||DECODE(substr(IT.POD_CD,1,2), 'US', LOC6.LOC_AMS_PORT_CD, LOC5.LOC_AMS_PORT_CD),80,' ')||CHR(10)||RPAD('B04'||'CSK'||LOC6.LOC_AMS_PORT_CD,80,' ')||CHR(10) B04ISF5," ).append("\n"); 
		query.append("			   RPAD(IT.BL_NO, 12, ' ') BL_NO," ).append("\n"); 
		query.append("			   NVL(IT.MF_NO, 'X') MF_NO," ).append("\n"); 
		query.append("			   ACT_FILE_SKD_DIR_CD," ).append("\n"); 
		query.append("               IT.POD_CD FPOD_CD," ).append("\n"); 
		query.append("               BKG.POD_CD BOOKING_POD_CD," ).append("\n"); 
		query.append("			   IT.MF_STS_CD" ).append("\n"); 
		query.append("			   ,CSTMS_LOC_CD" ).append("\n"); 
		query.append("		  FROM BKG_CSTMS_ADV_BL IT,  MDM_LOCATION  LOC, MDM_LOCATION LOC2, MDM_LOCATION LOC3, MDM_LOCATION LOC4, MDM_LOCATION LOC5, MDM_LOCATION LOC6, BKG_BOOKING BKG, BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("		 WHERE " ).append("\n"); 
		query.append("		   IT.CNT_CD = 'US'" ).append("\n"); 
		query.append("		   AND IT.BL_NO  in (SELECT COLUMN_VALUE BL_NO FROM TABLE(BKG_SPLIT_CLOB_FNC(${bl_no},',')) WHERE COLUMN_VALUE IS NOT NULL)" ).append("\n"); 
		query.append("		   AND IT.CSTMS_POL_CD   = LOC.LOC_CD" ).append("\n"); 
		query.append("		   AND IT.USA_LST_LOC_CD = LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.HUB_LOC_CD     = LOC3.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.POR_CD     	 = LOC4.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.CSTMS_POD_CD	 = LOC5.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.DEL_CD	 	 = LOC6.LOC_CD(+)" ).append("\n"); 
		query.append("		   AND IT.BKG_NO     	 = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND IT.BL_NO       	 = IBD.BL_NO(+)" ).append("\n"); 
		query.append("		   AND IT.CNT_CD      	 = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}