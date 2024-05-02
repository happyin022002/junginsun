/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOaddPkupNtcDtlByManualCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOaddPkupNtcDtlByManualCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manully로 P/N 대상 연락처 정보를 등록한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOaddPkupNtcDtlByManualCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOaddPkupNtcDtlByManualCSQL").append("\n"); 
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
		query.append("/* 삭제됨 !!!!!!!!!" ).append("\n"); 
		query.append("INSERT INTO BKG_PKUP_NTC_DTL (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	NTC_SEQ" ).append("\n"); 
		query.append(",	CUST_CNTC_TP_CD" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	FAX_TP_CD" ).append("\n"); 
		query.append(",	FAX_SND_DT" ).append("\n"); 
		query.append(",	FAX_SND_GDT" ).append("\n"); 
		query.append(",	FAX_SND_USR_ID" ).append("\n"); 
		query.append(",	FAX_NTC_SND_ID" ).append("\n"); 
		query.append(",	FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",	NTC_EML" ).append("\n"); 
		query.append(",	EML_TP_CD" ).append("\n"); 
		query.append(",	EML_SND_DT" ).append("\n"); 
		query.append(",	EML_SND_GDT" ).append("\n"); 
		query.append(",	EML_SND_USR_ID" ).append("\n"); 
		query.append(",	EML_NTC_SND_ID" ).append("\n"); 
		query.append(",	EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       PK.BKG_NO" ).append("\n"); 
		query.append("      ,PK.NTC_SEQ" ).append("\n"); 
		query.append("      ,D.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(D.FAX_SND_FLG,'Y',D.FAX_NO,NULL) AS FAX_NO" ).append("\n"); 
		query.append("      ,DECODE(PK.PKUP_NTC_TP_CD,'MA','M','A')  AS FAX_TP_CD" ).append("\n"); 
		query.append("      ,NULL AS FAX_SND_DT" ).append("\n"); 
		query.append("      ,NULL AS FAX_SND_GDT" ).append("\n"); 
		query.append("      ,NULL AS FAX_SND_USR_ID" ).append("\n"); 
		query.append("      ,NULL AS FAX_NTC_SND_ID" ).append("\n"); 
		query.append("      ,NULL AS FAX_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("      ,DECODE(D.EML_SND_FLG,'Y',D.CNTC_EML,NULL) AS NTC_EML" ).append("\n"); 
		query.append("      ,DECODE(PK.PKUP_NTC_TP_CD,'MA','M','A') AS EML_TP_CD" ).append("\n"); 
		query.append("      ,NULL AS EML_SND_DT" ).append("\n"); 
		query.append("      ,NULL AS EML_SND_GDT" ).append("\n"); 
		query.append("      ,NULL AS EML_SND_USR_ID" ).append("\n"); 
		query.append("      ,NULL AS EML_NTC_SND_ID" ).append("\n"); 
		query.append("      ,NULL AS EML_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("      ,@[cre_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC     PK" ).append("\n"); 
		query.append("      ,BKG_BOOKING      A" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     B" ).append("\n"); 
		query.append("      ,MDM_LOCATION     C" ).append("\n"); 
		query.append("      ,BKG_IB_CUST_CNTC D       " ).append("\n"); 
		query.append("WHERE  PK.BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("AND    PK.NTC_SEQ             = @[ntc_seq]" ).append("\n"); 
		query.append("AND    A.BKG_NO               = PK.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_CUST_TP_CD       = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("AND    B.BKG_NO               = PK.BKG_NO" ).append("\n"); 
		query.append("AND    B.CUST_CNT_CD          = PK.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    B.CUST_SEQ             = PK.CUST_SEQ" ).append("\n"); 
		query.append("AND    C.LOC_CD               = A.DEL_CD" ).append("\n"); 
		query.append("--AND    C.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("AND    D.CUST_CNT_CD          = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    D.CUST_SEQ             = B.CUST_SEQ" ).append("\n"); 
		query.append("AND    D.OFC_CD               = C.EQ_CTRL_OFC_CD " ).append("\n"); 
		query.append("AND    (D.FAX_SND_FLG = 'Y' OR D.EML_SND_FLG = 'Y')" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}