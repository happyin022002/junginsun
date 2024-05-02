/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT FF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '{I_BKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("       ||'IB_BKG_IND:' || BK.XTER_BKG_RQST_STS_CD || CHR(10) " ).append("\n"); 
		query.append("       ||'IB_PKG_QTY:' || BK.PCK_QTY || CHR(10) " ).append("\n"); 
		query.append("       ||'IB_PKG_CD:' || NVL(BK.PCK_TP_CD, ' ') || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POR_CD:' || BI.POR_CTNT || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POR_CD_TP_CD:' || BI.XTER_POR_TP_CD || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POR_NM:' || BI.POR_NM || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POL_CD:' || BI.POL_CTNT || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POL_CD_TP_CD:' || BI.XTER_POL_TP_CD || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POL_NM:' || BI.POL_NM || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POD_CD:' || BI.POD_CTNT || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POD_CD_TP_CD:' || BI.XTER_POD_TP_CD || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_POD_NM:' || BI.POD_NM || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_DEL_CD:' || BI.DEL_CTNT || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_DEL_CD_TP_CD:' || BI.XTER_DEL_TP_CD || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_DEL_NM:' || BI.DEL_NM || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_TRANS_IND:' || BI.TRNS_IND_CTNT || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_SR_AMT:' || CHR(10)" ).append("\n"); 
		query.append("       ||'IBI_DOC_ID:' || BI.DOC_USR_ID || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_DOC_SEQ:' || CHR(10) " ).append("\n"); 
		query.append("       ||'IBI_CHG_CD:' || CHR(10)" ).append("\n"); 
		query.append("       || '}I_BKG_INFO' || CHR(10) AS FF" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(PARTITION BY BK.XTER_SNDR_ID,BK.XTER_RQST_NO ORDER BY BK.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append("FROM  BKG_XTER_RQST_MST BK, BKG_XTER_INSTR BI" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BK.XTER_RQST_NO = BI.XTER_RQST_NO" ).append("\n"); 
		query.append("AND   BK.XTER_RQST_SEQ = BI.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND   BK.XTER_SNDR_ID = BI.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND   BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("AND   BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                       FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                       WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                         AND BXRM.BKG_UPLD_STS_CD = 'F') " ).append("\n"); 
		query.append(") FF" ).append("\n"); 
		query.append("WHERE RNUM =1" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}