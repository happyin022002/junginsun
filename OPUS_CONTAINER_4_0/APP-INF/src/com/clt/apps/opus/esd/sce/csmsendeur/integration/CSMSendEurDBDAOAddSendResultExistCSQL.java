/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOAddSendResultExistCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOAddSendResultExistCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSendResultExist
	  * </pre>
	  */
	public CSMSendEurDBDAOAddSendResultExistCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_yrmondy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOAddSendResultExistCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CSM_SND_RSLT_EUR (  " ).append("\n"); 
		query.append("ACT_RCV_DT,   " ).append("\n"); 
		query.append("ACT_RCV_NO,   " ).append("\n"); 
		query.append("STND_EDI_STS_CD,   " ).append("\n"); 
		query.append("EDI_SND_KNT,   " ).append("\n"); 
		query.append("EDI_SND_YRMONDY,   " ).append("\n"); 
		query.append("EDI_SND_SEQ,   " ).append("\n"); 
		query.append("BKG_NO,   				 " ).append("\n"); 
		query.append("CNTR_NO,  " ).append("\n"); 
		query.append("CSM_CNT_CD," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD,  " ).append("\n"); 
		query.append("NOD_CD,   " ).append("\n"); 
		query.append("ERR_MSG,  " ).append("\n"); 
		query.append("MNL_FLG,   " ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("ACT_DT, " ).append("\n"); 
		query.append("FLT_FILE_REF_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT A.ACT_RCV_DT, " ).append("\n"); 
		query.append("          A.ACT_RCV_NO, " ).append("\n"); 
		query.append("          A.STND_EDI_STS_CD, " ).append("\n"); 
		query.append("          NVL(B.EDI_SND_KNT, 0) + 1, " ).append("\n"); 
		query.append("          A.EDI_SND_YRMONDY, " ).append("\n"); 
		query.append("          A.EDI_SND_SEQ, " ).append("\n"); 
		query.append("          A.BKG_NO, 		    " ).append("\n"); 
		query.append("          A.CNTR_NO, " ).append("\n"); 
		query.append("          A.CSM_CNT_CD," ).append("\n"); 
		query.append("          A.ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("          A.NOD_CD, " ).append("\n"); 
		query.append("          A.ERR_MSG, " ).append("\n"); 
		query.append("          A.MNL_FLG, " ).append("\n"); 
		query.append("          A.CRE_USR_ID, " ).append("\n"); 
		query.append("          A.CRE_DT, " ).append("\n"); 
		query.append("          A.UPD_USR_ID," ).append("\n"); 
		query.append("          A.UPD_DT," ).append("\n"); 
		query.append("          A.ACT_DT, " ).append("\n"); 
		query.append("          A.FLT_FILE_REF_NO " ).append("\n"); 
		query.append("    FROM  (" ).append("\n"); 
		query.append("	     	SELECT A.ACT_RCV_DT, " ).append("\n"); 
		query.append("	               A.ACT_RCV_NO," ).append("\n"); 
		query.append("	               nvl(B.EDI_STS_CD, 'X') AS STND_EDI_STS_CD," ).append("\n"); 
		query.append("	               B.EDI_SND_YRMONDY, " ).append("\n"); 
		query.append("	               B.EDI_SND_SEQ, " ).append("\n"); 
		query.append("	               A.BKG_NO, " ).append("\n"); 
		query.append("	               A.CNTR_NO," ).append("\n"); 
		query.append("                   A.CSM_CNT_CD,  " ).append("\n"); 
		query.append("	               A.ACT_STS_MAPG_CD, " ).append("\n"); 
		query.append("	               A.NOD_CD, " ).append("\n"); 
		query.append("	               @[err_msg] AS ERR_MSG, " ).append("\n"); 
		query.append("	               'N' AS MNL_FLG, " ).append("\n"); 
		query.append("	               'SYSTEM1' AS CRE_USR_ID, " ).append("\n"); 
		query.append("	               SYSDATE AS CRE_DT, " ).append("\n"); 
		query.append("     		       'SYSTEM1' AS UPD_USR_ID," ).append("\n"); 
		query.append("		           SYSDATE AS UPD_DT, " ).append("\n"); 
		query.append("	               A.ACT_DT, " ).append("\n"); 
		query.append("	               @[flt_file_ref_no] AS FLT_FILE_REF_NO " ).append("\n"); 
		query.append("	          FROM SCE_CSM_TGT_EUR A, " ).append("\n"); 
		query.append("	               SCE_CSM_FLT_FILE_EUR B " ).append("\n"); 
		query.append("	         WHERE 1=1" ).append("\n"); 
		query.append("               AND A.ACT_RCV_DT = B.ACT_RCV_DT (+) " ).append("\n"); 
		query.append("	           AND A.ACT_RCV_NO = B.ACT_RCV_NO (+) " ).append("\n"); 
		query.append("	           AND A.ACT_RCV_DT = @[act_rcv_dt] " ).append("\n"); 
		query.append("	           AND A.ACT_RCV_NO = @[act_rcv_no]  " ).append("\n"); 
		query.append("	           AND B.EDI_SND_YRMONDY = @[edi_snd_yrmondy]  " ).append("\n"); 
		query.append("	           AND B.EDI_SND_SEQ = @[edi_snd_seq] ) A, " ).append("\n"); 
		query.append("	      (  " ).append("\n"); 
		query.append("            SELECT ACT_RCV_DT, " ).append("\n"); 
		query.append("		           ACT_RCV_NO, " ).append("\n"); 
		query.append("		           STND_EDI_STS_CD, " ).append("\n"); 
		query.append("		           MAX(NVL(EDI_SND_KNT, 0)) AS EDI_SND_KNT " ).append("\n"); 
		query.append("	          FROM SCE_CSM_SND_RSLT_EUR " ).append("\n"); 
		query.append("	         WHERE 1=1" ).append("\n"); 
		query.append("               AND ACT_RCV_DT = @[act_rcv_dt]  " ).append("\n"); 
		query.append("		       AND ACT_RCV_NO = @[act_rcv_no]  " ).append("\n"); 
		query.append("          GROUP BY ACT_RCV_DT, ACT_RCV_NO, STND_EDI_STS_CD ) B " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE A.ACT_RCV_DT = B.ACT_RCV_DT (+) " ).append("\n"); 
		query.append("      AND A.ACT_RCV_NO = B.ACT_RCV_NO (+) " ).append("\n"); 
		query.append("      AND A.STND_EDI_STS_CD = B.STND_EDI_STS_CD (+) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}