/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalMailListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalMailListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalMailListData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalMailListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalMailListDataRSQL").append("\n"); 
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
		query.append("SELECT A.MNR_PRNR_EML AS RECIPIENT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS SUBJECT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS TEXTCONTENT," ).append("\n"); 
		query.append("       @[mnr_prnr_eml] AS SENDER" ).append("\n"); 
		query.append("  FROM MNR_PARTNER A" ).append("\n"); 
		query.append(" WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("   AND (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN (SELECT MNR_PRNR_CNT_CD," ).append("\n"); 
		query.append("                                                      MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                 FROM MNR_DISP_BUYR_PART" ).append("\n"); 
		query.append("                                                WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("                                                  AND MNR_PRNR_EML = 'Y'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("   AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_EML IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT B.MNR_PRNR_EML AS RECIPIENT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS SUBJECT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS TEXTCONTENT," ).append("\n"); 
		query.append("       @[mnr_prnr_eml] AS SENDER" ).append("\n"); 
		query.append("  FROM MNR_PARTNER A, MNR_PRNR_CNTC_PNT B" ).append("\n"); 
		query.append(" WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("   AND (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN (SELECT MNR_PRNR_CNT_CD," ).append("\n"); 
		query.append("                                                      MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                 FROM MNR_DISP_BUYR_PART" ).append("\n"); 
		query.append("                                                WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("                                                  AND MNR_PRNR_EML = 'Y'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_CRE_SEQ  = B.MNR_PRNR_CRE_SEQ(+)" ).append("\n"); 
		query.append("   AND B.OFC_CD = ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_KND_CD = 'G'" ).append("\n"); 
		query.append("   AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_EML IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT B.MNR_PRNR_EML AS RECIPIENT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS SUBJECT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS TEXTCONTENT," ).append("\n"); 
		query.append("       @[mnr_prnr_eml] AS SENDER" ).append("\n"); 
		query.append("  FROM MNR_PARTNER A, MNR_PRNR_CNTC_PNT B" ).append("\n"); 
		query.append(" WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("   AND (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN (SELECT MNR_PRNR_CNT_CD," ).append("\n"); 
		query.append("                                                      MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                 FROM MNR_DISP_BUYR_PART" ).append("\n"); 
		query.append("                                                WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("                                                  AND MNR_PRNR_EML = 'Y'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_CRE_SEQ  = B.MNR_PRNR_CRE_SEQ(+)" ).append("\n"); 
		query.append("   AND B.OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(@[rqst_ofc_cd])" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_KND_CD = 'R'" ).append("\n"); 
		query.append("   AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_EML IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT B.MNR_PRNR_EML AS RECIPIENT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS SUBJECT," ).append("\n"); 
		query.append("       'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS TEXTCONTENT," ).append("\n"); 
		query.append("       @[mnr_prnr_eml] AS SENDER" ).append("\n"); 
		query.append("  FROM MNR_PARTNER A, MNR_PRNR_CNTC_PNT B" ).append("\n"); 
		query.append(" WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("   AND (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN (SELECT MNR_PRNR_CNT_CD," ).append("\n"); 
		query.append("                                                      MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                                 FROM MNR_DISP_BUYR_PART" ).append("\n"); 
		query.append("                                                WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("                                                  AND MNR_PRNR_EML = 'Y'" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_CRE_SEQ  = B.MNR_PRNR_CRE_SEQ(+)" ).append("\n"); 
		query.append("   AND B.OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("   AND A.MNR_PRNR_KND_CD = 'L'" ).append("\n"); 
		query.append("   AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("   AND B.MNR_PRNR_EML IS NOT NULL" ).append("\n"); 

	}
}