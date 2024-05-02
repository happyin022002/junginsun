/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArrivalNoticeDBDAOBkgIbCustCntcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13 
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

public class ArrivalNoticeDBDAOBkgIbCustCntcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOBkgIbCustCntcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq_ib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd_ib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOBkgIbCustCntcRSQL").append("\n"); 
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
		query.append("SELECT B.OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("      --,B.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("	  ,D.INTG_CD_VAL_CTNT AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("      ,B.FAX_NO" ).append("\n"); 
		query.append("      ,B.FAX_NO FAX_NO_ORG" ).append("\n"); 
		query.append("      ,DECODE(B.FAX_SND_FLG,'N',1,'Y',0) AS FAX_SND_FLG" ).append("\n"); 
		query.append("	  ,DECODE(B.FAX_SND_FLG,'N',1,'Y',0) AS FAX_SND_FLG_ORG" ).append("\n"); 
		query.append("      ,B.CNTC_EML" ).append("\n"); 
		query.append("      ,B.CNTC_EML CNTC_EML_ORG" ).append("\n"); 
		query.append("      ,DECODE(B.EML_SND_FLG,'N',1,'Y',0) AS EML_SND_FLG" ).append("\n"); 
		query.append("      ,DECODE(B.EML_SND_FLG,'N',1,'Y',0) AS EML_SND_FLG_ORG" ).append("\n"); 
		query.append("      ,B.PHN_NO" ).append("\n"); 
		query.append("      ,B.MPHN_NO" ).append("\n"); 
		query.append("      ,B.UPD_LOCL_DT AS UPD_DT" ).append("\n"); 
		query.append("      ,B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,C.USR_NM" ).append("\n"); 
		query.append("      ,B.CNTC_RMK" ).append("\n"); 
		query.append("      ,B.CUST_CNT_CD || B.CUST_SEQ AS CUST_CD" ).append("\n"); 
		query.append("      ,B.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,B.CUST_SEQ" ).append("\n"); 
		query.append("      ,B.CRE_USR_ID" ).append("\n"); 
		query.append("      , (SELECT COUNT(1)" ).append("\n"); 
		query.append("              FROM BKG_IB_CMDT_CNTC CMDT " ).append("\n"); 
		query.append("             WHERE CMDT.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("               AND CMDT.CUST_CNT_CD = @[cust_cnt_cd_ib]" ).append("\n"); 
		query.append("               AND CMDT.CUST_SEQ = @[cust_seq_ib]" ).append("\n"); 
		query.append("               AND CMDT.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("               AND ROWNUM = 1 ) AS IB_CMDT_FLG" ).append("\n"); 
		query.append("  FROM BKG_IB_CUST_CNTC B" ).append("\n"); 
		query.append("      ,COM_USER         C" ).append("\n"); 
		query.append("	  ,COM_INTG_CD_DTL  D" ).append("\n"); 
		query.append(" WHERE B.CUST_CNTC_TP_CD(+) = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("   --AND B.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND B.UPD_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("   AND D.INTG_CD_ID = 'CD02129'" ).append("\n"); 
		query.append("   AND B.OFC_CD(+) = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD(+) = @[cust_cnt_cd_ib]  " ).append("\n"); 
		query.append("   AND B.CUST_SEQ(+) = @[cust_seq_ib]" ).append("\n"); 
		query.append("ORDER BY D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}