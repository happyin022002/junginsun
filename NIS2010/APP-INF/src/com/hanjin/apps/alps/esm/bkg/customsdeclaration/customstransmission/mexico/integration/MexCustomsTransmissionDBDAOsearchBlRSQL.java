/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DWKIM, 0370, OUTVO : MxBlInfoVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchBlRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchBlRSQL").append("\n"); 
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
		query.append("SELECT   NVL(BK.BL_NO||BK.BL_TP_CD,' ')			BLNBR                                                	" ).append("\n"); 
		query.append("        ,NVL(BK.POL_CD, ' ')					BLPOL                                                	" ).append("\n"); 
		query.append("        ,LOC1.LOC_AMS_PORT_CD                 	POL_AMS                                            		" ).append("\n"); 
		query.append("        ,LOC1.LOC_NM                          	POL_FULLNAME                                       		" ).append("\n"); 
		query.append("        ,CASE WHEN NVL(BK.POD_CD, ' ') = 'XXXXX' THEN @[pod_cd] ELSE NVL(BK.POD_CD, ' ') END BLPOD" ).append("\n"); 
		query.append("        ,LOC2.LOC_AMS_PORT_CD                 	POD_AMS                                           			" ).append("\n"); 
		query.append("        ,LOC2.LOC_NM                          	POD_FULLNAME                                       		" ).append("\n"); 
		query.append("        ,NVL(BK.POR_CD, ' ')					BLPOR                                                	" ).append("\n"); 
		query.append("        ,LOC3.LOC_AMS_PORT_CD                 	POR_AMS                                             		" ).append("\n"); 
		query.append("        ,LOC3.LOC_NM                          	POR_FULLNAME                                       		" ).append("\n"); 
		query.append("        ,CASE WHEN NVL(BK.DEL_CD, ' ') = 'XXXXX' AND NVL(BK.POD_CD, ' ') = 'XXXXX' THEN @[pod_cd]" ).append("\n"); 
		query.append("              WHEN NVL(BK.DEL_CD, ' ') = 'XXXXX' AND NVL(BK.POD_CD, ' ') != 'XXXXX' THEN NVL(BK.POD_CD, ' ')" ).append("\n"); 
		query.append("	          ELSE NVL(BK.DEL_CD, ' ')" ).append("\n"); 
		query.append("         END BLDEL             " ).append("\n"); 
		query.append("        ,LOC4.LOC_AMS_PORT_CD                 	DEL_AMS                                         		" ).append("\n"); 
		query.append("        ,LOC4.LOC_NM                          	DEL_FULLNAME                                       		" ).append("\n"); 
		query.append("        ,DECODE(@[pol_cd], NULL, NVL(BK.PST_RLY_PORT_CD, ' '), NVL(BK.PRE_RLY_PORT_CD, ' ')) BLRLY		" ).append("\n"); 
		query.append("        ,LOC5.LOC_AMS_PORT_CD 									RLY_AMS                                               							  " ).append("\n"); 
		query.append("        ,LOC5.LOC_NM        									RLY_FULLNAME                                                          		            " ).append("\n"); 
		query.append("        ,OFC.LOC_CD         									BLPLACE                                                                 	" ).append("\n"); 
		query.append("        ,NVL(TO_CHAR(BBI.OBL_ISS_DT ,'RRMMDD'),' ')    		BLDATE                                                                  	" ).append("\n"); 
		query.append("        ,NVL(BCS.CUST_CNT_CD, ' ') 	   						SHPRCN                                                                  	" ).append("\n"); 
		query.append("        ,NVL(TO_CHAR(BCS.CUST_SEQ), ' ') 	      				SHPRCD                                                                  	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,   1),'*','-')	SHPR1                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,   2),'*','-')	SHPR2                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1),'*','-')	SHPR3                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2),'*','-')	SHPR4                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3),'*','-')	SHPR5" ).append("\n"); 
		query.append("		,NVL(LIC.MX_SHPR_TAX_ID, ' ')							SHPRTAXID                                                                   	" ).append("\n"); 
		query.append("        ,NVL(BCC.CUST_CNT_CD, ' ')    							CNEECN                                                                  	" ).append("\n"); 
		query.append("        ,NVL(TO_CHAR(BCC.CUST_SEQ), ' ')      					CNEECD                                                                  	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,   1),'*','-')	CNEE1                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,   2),'*','-')	CNEE2                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1),'*','-')	CNEE3                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2),'*','-')	CNEE4                                                                   	" ).append("\n"); 
		query.append("        ,REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3),'*','-')	CNEE5 " ).append("\n"); 
		query.append("		,NVL(LIC.MX_CNEE_TAX_ID, ' ')							CNEETAXID" ).append("\n"); 
		query.append("        ,BK.BL_NO" ).append("\n"); 
		query.append("		,NVL(BK.BKG_CGO_TP_CD,' ') IN_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		,NVL(BK.DCGO_FLG,' ') IN_DCGO_FLG                                        " ).append("\n"); 
		query.append("		,NVL(BK.RC_FLG,' ') IN_RC_FLG                                            " ).append("\n"); 
		query.append("		,NVL(BK.AWK_CGO_FLG,' ') IN_AWK_CGO_FLG                                  " ).append("\n"); 
		query.append("		,NVL(BK.BB_CGO_FLG,' ') IN_BB_CGO_FLG                                    " ).append("\n"); 
		query.append("		,NVL(BK.RD_CGO_FLG,' ') IN_RD_CGO_FLG      		" ).append("\n"); 
		query.append("		,NVL(BK.CMDT_CD, ' ') CMDT_CD" ).append("\n"); 
		query.append("		,BBD.CSTMS_DESC		CMDT_NM" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("        BKG_BOOKING BK                                                                               " ).append("\n"); 
		query.append("        ,BKG_BL_ISS  BBI                                                                              " ).append("\n"); 
		query.append("        ,BKG_BL_DOC  BBD                                                                              " ).append("\n"); 
		query.append("        ,BKG_RATE    BR                                                                               " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCS                                                                             " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCC                                                                      " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC1                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC2                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC3                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC4                                                                        " ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC5                                                                        " ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION OFC                                                                         " ).append("\n"); 
		query.append("        ,MDM_COMMODITY    COM" ).append("\n"); 
		query.append("		,BKG_XPT_IMP_LIC  LIC                                                                         " ).append("\n"); 
		query.append("WHERE   BK.BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBI.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBD.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   BCS.BKG_CUST_TP_CD(+) =   'S'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   BCC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("   AND   BK.POR_CD         =   LOC3.LOC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.POL_CD         =   LOC1.LOC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.POD_CD         =   LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.DEL_CD         =   LOC4.LOC_CD(+)" ).append("\n"); 
		query.append("   AND   LOC5.LOC_CD(+)    = DECODE(@[pol_cd], NULL, NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' '))" ).append("\n"); 
		query.append("   AND   BBI.OBL_ISS_OFC_CD      = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.CMDT_CD         = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO			= LIC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND   ROWNUM = 1" ).append("\n"); 

	}
}