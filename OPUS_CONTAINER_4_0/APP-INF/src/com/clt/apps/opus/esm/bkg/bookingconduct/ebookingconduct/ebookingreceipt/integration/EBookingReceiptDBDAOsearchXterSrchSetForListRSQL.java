/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterSrchSetForListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : Hyunhwa Kim
*@LastVersion : 1.0
* 2010.12.01 Hyunhwa Kim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterSrchSetForListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterSrchSetForList
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterSrchSetForListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterSrchSetForListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(ROWNUM,1,'AND (', 'OR ') || '(1=1 ' || " ).append("\n"); 
		query.append("  DECODE(XTER_SNDR_ID, NULL,' ', ' AND XTER_SNDR_ID =''' ||XTER_SNDR_ID || '''')||  " ).append("\n"); 
		query.append("  DECODE(CHN_AGN_CD,        NULL,' ', ' AND SUBSTR(BKG_NO,5,2) = ''' || CHN_AGN_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(DOC_TP_CD,         NULL,' ', ' AND DOC_TP_CD = ''' || DOC_TP_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(BKG_UPLD_STS_CD,   NULL,' ', 'D', ' AND RQST_DELT_FLG = ''Y''', ' AND BKG_UPLD_STS_CD = ''' || BKG_UPLD_STS_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(XTER_RQST_VIA_CD,  NULL,' ', ' AND XTER_RQST_VIA_CD = ''' || XTER_RQST_VIA_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(ORG_CNT_CD,        NULL,' ', ' AND ''' || ORG_CNT_CD || ''' IN (POR.CNT_CD, POL.CNT_CD)') || " ).append("\n"); 
		query.append("  DECODE(DEL_CONTI_CD,      NULL,' ', ' AND MST.DEL_CN ' ||" ).append("\n"); 
		query.append("                                        ' IN (''' || DECODE(DEL_CONTI_CD,  'E', 'F'',''E', DEL_CONTI_CD) || ''')') ||" ).append("\n"); 
		query.append("  DECODE(HNDL_OFC_CD,       NULL,' ', ' AND MST.HNDL_OFC_CD = ''' || HNDL_OFC_CD || '''') ||   " ).append("\n"); 
		query.append("  DECODE(CUST_CNT_CD,       NULL,' ', ' AND decode('''||srch.bkg_cust_tp_cd||''', ''F'', ff_cnt, ''C'', cn_cnt, sh_cnt) = '''||srch.cust_cnt_cd||'''')||" ).append("\n"); 
		query.append("  DECODE(CUST_SEQ, 0, ' ',  NULL,' ', ' AND decode('''||srch.bkg_cust_tp_cd||''', ''F'', ff_seq, ''C'', cn_seq, sh_seq) = '''||srch.CUST_SEQ||'''')||" ).append("\n"); 
		query.append("  DECODE(CUST_NM,       	NULL,' ', ' AND decode('''||srch.bkg_cust_tp_cd||''', ''F'', ff_nm,  ''C'', cn_nm,  sh_nm)  like '''||srch.CUST_NM||'%''')||" ).append("\n"); 
		query.append("  DECODE(SLAN_CD,           NULL,' ', ' AND SLAN_CD = ''' || SLAN_CD || '''') || " ).append("\n"); 
		query.append("  DECODE(SREP_CD,           NULL,' ', ' AND (SREP_CD = DECODE(MST.DOC_TP_CD, ''S'', '''||SREP_CD||''', '' '')' || " ).append("\n"); 
		query.append("                        ' OR (sh_cnt, sh_seq) IN ' || " ).append("\n"); 
		query.append("                        '(SELECT CUST.cust_CNT_CD, CUST.CUST_SEQ '||" ).append("\n"); 
		query.append("                        '   FROM MDM_CUSTOMER CUST, BKG_CUST_SLS_REP SREP '|| " ).append("\n"); 
		query.append("                        '  WHERE CUST.cust_CNT_CD   = SREP.cust_CNT_CD '|| " ).append("\n"); 
		query.append("                        '    AND CUST.CUST_SEQ      = SREP.CUST_SEQ '|| " ).append("\n"); 
		query.append("                        '    AND SREP.DELT_FLG      = ''N'''|| " ).append("\n"); 
		query.append("--						'    AND SREP.SREP_CD       = '''|| SREP_CD ||'''))')||" ).append("\n"); 
		query.append("                        '    AND SREP.SREP_CD       = DECODE(MST.DOC_TP_CD, ''S'', '' '','''|| SREP_CD ||''')))')||" ).append("\n"); 
		query.append("  ')' CUST_NM" ).append("\n"); 
		query.append("FROM BKG_XTER_SRCH_SET srch" ).append("\n"); 
		query.append("WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND SET_SLCT_FLG = 'Y'" ).append("\n"); 

	}
}