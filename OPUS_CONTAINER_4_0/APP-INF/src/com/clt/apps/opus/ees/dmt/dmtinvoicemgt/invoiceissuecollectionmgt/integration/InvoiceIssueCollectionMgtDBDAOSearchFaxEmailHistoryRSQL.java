/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_7006
	  * Fax/E-mail Sending History
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndrcdd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shttppp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndfrdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndtodt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payercd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if ( ${seloptt} == '0' )" ).append("\n"); 
		query.append("		DECODE ( DMDT_SND_DOC_TP_CD , 'D' , DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0')" ).append("\n"); 
		query.append("                                    , 'O' , DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0')" ).append("\n"); 
		query.append("                                    , DMDT_INV_NO" ).append("\n"); 
		query.append("               ) AS INVNOO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${seloptt} == '1' )" ).append("\n"); 
		query.append("		  DMDT_INV_NO AS INVNOO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${seloptt} == '2' )" ).append("\n"); 
		query.append("		  DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0') AS INVNOO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          DMDT_SND_DOC_TP_CD                   									AS SHTYPE" ).append("\n"); 
		query.append("        , DECODE ( DMDT_FAX_EML_SND_TP_CD , 'F' , DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("                                          , DMDT_PAYR_EML" ).append("\n"); 
		query.append("                 ) AS FAXEML" ).append("\n"); 
		query.append("        , DECODE ( DMDT_FAX_EML_SND_TP_CD , 'E' , ( SELECT DECODE(EML_PROC_STS_CD, 3, 'Sent Successfully', '') FROM COM_EML_SND_INFO WHERE EML_SND_NO = FAX_EML_SND_NO )" ).append("\n"); 
		query.append("                     , ( SELECT DECODE(FAX_PROC_STS_CD, 5, 'Sent Successfully', NVL( XPT_ERR_MSG , FAX_ERR_MSG )) FROM COM_FAX_SND_INFO WHERE RD_SUB_SYS_CD = 'DMT' AND FAX_SND_NO = FAX_EML_SND_NO )" ).append("\n"); 
		query.append("                 ) AS RSTMSG" ).append("\n"); 
		query.append("        , TO_CHAR( CRE_DT , 'YYYY-MM-DD HH24:mi' )     					AS SNDDAT" ).append("\n"); 
		query.append("        , CRE_OFC_CD                           					AS SNDOFF" ).append("\n"); 
		query.append("        , CRE_USR_ID                           					AS SNDRID" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("                USR_NM" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("                COM_USER" ).append("\n"); 
		query.append("          WHERE" ).append("\n"); 
		query.append("                USR_ID = H.CRE_USR_ID" ).append("\n"); 
		query.append("          )                                    AS SNDRNM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DMT_FAX_EML_SND_HIS H" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sndfrdt} != '' && ${sndtodt} != '' )" ).append("\n"); 
		query.append("AND     CRE_DT BETWEEN TO_DATE(@[sndfrdt], 'YYYY-MM-DD') AND TO_DATE(@[sndtodt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sndoffc} != '' && ${sndoffc} != 'All' && ${seloptt} == '0' )" ).append("\n"); 
		query.append("AND	    CRE_OFC_CD IN (" ).append("\n"); 
		query.append("    #foreach( $cre_ofc_cd_p in ${tempSNDOFFCList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempSNDOFFCList.size()) " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${sndrcdd} != '' )" ).append("\n"); 
		query.append("AND     CRE_USR_ID = @[sndrcdd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${invoice} != '' )" ).append("\n"); 
		query.append("AND	    DMDT_INV_NO IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_inv_no_p in ${tempINVOICEList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempINVOICEList.size()) " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payercd]), 8, NVL(SUBSTR(@[payercd], 1, 2), ACT_PAYR_CNT_CD), 6, ACT_PAYR_CNT_CD, ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("AND     ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payercd]), 8, NVL(SUBSTR(@[payercd], 3, 6), ACT_PAYR_SEQ), 6, @[payercd], ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${shttppp} != 'A' && ${shttppp} != '')" ).append("\n"); 
		query.append("		AND		DMDT_SND_DOC_TP_CD = @[shttppp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("#if ( ${seloptt} == '0' )" ).append("\n"); 
		query.append("		DECODE ( DMDT_SND_DOC_TP_CD , 'D' , DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0')" ).append("\n"); 
		query.append("                                    , 'O' , DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0')" ).append("\n"); 
		query.append("                                    , DMDT_INV_NO" ).append("\n"); 
		query.append("               )," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${seloptt} == '1' )" ).append("\n"); 
		query.append("		  DMDT_INV_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${seloptt} == '2' )" ).append("\n"); 
		query.append("		  DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||LPAD(ACT_PAYR_SEQ,6,'0')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" DMDT_SND_DOC_TP_CD" ).append("\n"); 
		query.append(",DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append(",DMDT_PAYR_EML" ).append("\n"); 
		query.append(",FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",FAX_EML_SND_NO" ).append("\n"); 
		query.append(",DMDT_FAX_EML_SND_TP_CD" ).append("\n"); 
		query.append("ORDER BY CRE_DT DESC" ).append("\n"); 

	}
}