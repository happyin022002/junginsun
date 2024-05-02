/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT    DECODE(C.BKG_CUST_TP_CD,'S','SH','C','CN','F','FW','N','N1','A','N2') CUSTOMER_TYPE" ).append("\n"); 
		query.append("         ,C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ,'000000') CUSTOMER_CD" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("         ,CASE WHEN C.ADDR_PRN_FLG = 'N' AND C.BKG_CUST_TP_CD = 'F' THEN ''" ).append("\n"); 
		query.append("		  ELSE 	CASE WHEN C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                THEN DECODE(@[spc_loc],'SGSIN','SM SINGAPORE','MYPKG','SM PORT KLANG',REPLACE(BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_NM), 'J'),CHR(13)||CHR(10),' '))" ).append("\n"); 
		query.append("		 		ELSE REPLACE(BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_NM), 'J'),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("	     		END" ).append("\n"); 
		query.append("          END CUSTOMER_NM1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("		 ,CASE WHEN C.ADDR_PRN_FLG = 'N' AND C.BKG_CUST_TP_CD = 'F' " ).append("\n"); 
		query.append("            THEN ''" ).append("\n"); 
		query.append("		  ELSE	CASE WHEN C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("            THEN DECODE(@[spc_loc],'SGSIN','','MYPKG','','')" ).append("\n"); 
		query.append("		 		ELSE ''" ).append("\n"); 
		query.append("		 		END" ).append("\n"); 
		query.append("          END CUSTOMER_NM2" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("		 ,CASE WHEN C.ADDR_PRN_FLG = 'Y' THEN " ).append("\n"); 
		query.append("			CASE WHEN C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                THEN DECODE(@[spc_loc],'SGSIN','SM LINE (SINGAPORE)PTE CORPORATION','MYPKG','SM LINE MALAYSIA SDN BHD'," ).append("\n"); 
		query.append("                    CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1) != 0 " ).append("\n"); 
		query.append("                    THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)-1),'J') " ).append("\n"); 
		query.append("                    ELSE BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1),'J') END)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("		 	ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1) != 0 " ).append("\n"); 
		query.append("                THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)-1),'J') " ).append("\n"); 
		query.append("                ELSE BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, 1),'J') " ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("		 	END" ).append("\n"); 
		query.append("		  ELSE ''" ).append("\n"); 
		query.append("          END CUSTOMER_ADDR1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("		 ,CASE WHEN C.ADDR_PRN_FLG = 'Y' THEN " ).append("\n"); 
		query.append("			CASE WHEN C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                THEN DECODE(@[spc_loc],'SGSIN','460 ALEXANDRA ROAD,','MYPKG','C605, LEVEL 6 , WISMA CONSPLANT 1'," ).append("\n"); 
		query.append("                    CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2) != 0 " ).append("\n"); 
		query.append("                    THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)+2, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)-2-INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)),'J') " ).append("\n"); 
		query.append("                        ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1) != 0 " ).append("\n"); 
		query.append("                        THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)+2),'J') " ).append("\n"); 
		query.append("                        ELSE null END END)" ).append("\n"); 
		query.append("		 	ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2) != 0 " ).append("\n"); 
		query.append("                THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)+2, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)-2-INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)),'J')" ).append("\n"); 
		query.append("                    ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1) != 0 " ).append("\n"); 
		query.append("                    THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 1)+2) ,'J')" ).append("\n"); 
		query.append("                    ELSE null END END" ).append("\n"); 
		query.append("		 	END" ).append("\n"); 
		query.append("		  ELSE ''" ).append("\n"); 
		query.append("          END CUSTOMER_ADDR2" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("		 ,CASE WHEN C.ADDR_PRN_FLG = 'Y' THEN " ).append("\n"); 
		query.append("			CASE WHEN C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                THEN DECODE(@[spc_loc],'SGSIN','#07-02/06, PSA BUILDING','MYPKG','NO : 2 JALAN SS16/4 , 47500'," ).append("\n"); 
		query.append("                    CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 3) != 0 " ).append("\n"); 
		query.append("                    THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)+2, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 3)-2-INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)) ,'J')" ).append("\n"); 
		query.append("                    ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2) != 0 " ).append("\n"); 
		query.append("                    THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)+2) ,'J')" ).append("\n"); 
		query.append("                    ELSE null END END)" ).append("\n"); 
		query.append("		 	ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 3) != 0 " ).append("\n"); 
		query.append("                THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)+2, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 3)-2-INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)) ,'J')" ).append("\n"); 
		query.append("                ELSE CASE WHEN INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2) != 0 " ).append("\n"); 
		query.append("                THEN BKG_SPCLCHAR_CONV_FNC(SUBSTR(C.CUST_ADDR, INSTR(C.CUST_ADDR, CHR(13)||CHR(10), 1, 2)+2) ,'J')" ).append("\n"); 
		query.append("                ELSE null END END" ).append("\n"); 
		query.append("		 	END" ).append("\n"); 
		query.append("		  ELSE ''" ).append("\n"); 
		query.append("          END CUSTOMER_ADDR3" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,( SELECT U.USR_NM     FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_NM " ).append("\n"); 
		query.append("         ,( SELECT U.XTN_PHN_NO FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_TEL " ).append("\n"); 
		query.append("         ,( SELECT U.FAX_NO     FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_FAX " ).append("\n"); 
		query.append("         ,( SELECT U.USR_EML    FROM COM_USER U WHERE USR_ID = @[usr_id] ) CONTACT_EMAIL " ).append("\n"); 
		query.append("FROM      BKG_CUSTOMER C" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       C.BKG_CUST_TP_CD IN ('C','F','N','S')" ).append("\n"); 
		query.append("AND 	  C.CUST_NM IS NOT NULL" ).append("\n"); 
		query.append("--AND       C.CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("--AND       C.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY  BKG_CUST_TP_CD DESC" ).append("\n"); 

	}
}