/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchArrNtcSndHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.23 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchArrNtcSndHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchArrNtcSndHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchArrNtcSndHistRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("--,HIS_SEQ" ).append("\n"); 
		query.append(",A.NTC_VIA_CD" ).append("\n"); 
		query.append("--,NTC_KND_CD" ).append("\n"); 
		query.append("--,CNTR_NO" ).append("\n"); 
		query.append("--,AGN_CD" ).append("\n"); 
		query.append("--,NTC_FOM_CD" ).append("\n"); 
		query.append("--,NTC_SEQ" ).append("\n"); 
		query.append("--,BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",A.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",DECODE(A.NTC_FAX_NO,NULL,NULL,NVL(B.FAX_NO,A.NTC_FAX_NO)) AS NTC_FAX_NO" ).append("\n"); 
		query.append(",DECODE(A.NTC_EML,NULL,NULL,NVL(B.NTC_EML,A.NTC_EML))   AS NTC_EML" ).append("\n"); 
		query.append("/*,SND_ID" ).append("\n"); 
		query.append(",EDI_ID" ).append("\n"); 
		query.append(",ESVC_GRP_CD" ).append("\n"); 
		query.append(",BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",TML_NTC_SND_STS_CD" ).append("\n"); 
		query.append(",CGOR_RCVR_TP_CD" ).append("\n"); 
		query.append(",CGOR_STS_CD" ).append("\n"); 
		query.append(",FRT_HDN_FLG" ).append("\n"); 
		query.append(",FRT_ALL_FLG" ).append("\n"); 
		query.append(",FRT_CLT_FLG" ).append("\n"); 
		query.append(",FRT_PPD_FLG" ).append("\n"); 
		query.append(",FRT_CHG_FLG" ).append("\n"); 
		query.append(",FRT_ARR_FLG" ).append("\n"); 
		query.append(",SND_OFC_CD" ).append("\n"); 
		query.append(",SND_USR_ID" ).append("\n"); 
		query.append(",SND_RQST_DT" ).append("\n"); 
		query.append(",SND_RTY_KNT" ).append("\n"); 
		query.append(",SND_DT" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CUST_CNTC_AMD_FLG" ).append("\n"); 
		query.append(",DP_HDN_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",SND_GDT" ).append("\n"); 
		query.append(",DO_EDI_TP_CD*/" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT /*+ index_desc(BNTC XPKBKG_NTC_HIS) */" ).append("\n"); 
		query.append("BNTC.*" ).append("\n"); 
		query.append("FROM   BKG_BOOKING  BKGM" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCST" ).append("\n"); 
		query.append(",BKG_NTC_HIS  BNTC" ).append("\n"); 
		query.append("WHERE  BKGM.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("AND    BCST.BKG_NO            = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND    BCST.BKG_CUST_TP_CD    = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("AND    BCST.AN_SND_FLG        = 'Y'" ).append("\n"); 
		query.append("AND    BNTC.BKG_NO            = BCST.BKG_NO" ).append("\n"); 
		query.append("AND    BNTC.BKG_CUST_TP_CD    = BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("AND    BNTC.NTC_KND_CD        = 'AN'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(B XPKBKG_HLD_NTC) */" ).append("\n"); 
		query.append("C.*" ).append("\n"); 
		query.append("FROM   BKG_HLD_NTC     A" ).append("\n"); 
		query.append(",BKG_HLD_NTC     B" ).append("\n"); 
		query.append(",BKG_HLD_NTC_DTL C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.NTC_SEQ          = @[ntc_seq]" ).append("\n"); 
		query.append("AND    B.BKG_NO           = A.BKG_NO" ).append("\n"); 
		query.append("AND    B.HLD_NTC_TP_CD    = 'PH'" ).append("\n"); 
		query.append("AND    B.CUST_CNT_CD      = A.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    B.CUST_SEQ         = A.CUST_SEQ" ).append("\n"); 
		query.append("AND    B.CSTMS_PRE_HLD_CD = A.CSTMS_PRE_HLD_CD" ).append("\n"); 
		query.append("AND    C.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("AND    C.NTC_SEQ          = B.NTC_SEQ" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO          = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.CUST_CNTC_TP_CD = B.CUST_CNTC_TP_CD(+)" ).append("\n"); 

	}
}