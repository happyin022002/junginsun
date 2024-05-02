/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDispContractMailListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.25 
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

public class DisposalMgtDBDAOsearchDispContractMailListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDispContractMailListDataRSQL(){
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
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDispContractMailListDataRSQL").append("\n"); 
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
		query.append("'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS SUBJECT," ).append("\n"); 
		query.append("'Disposal Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh24:mi') AS TEXTCONTENT," ).append("\n"); 
		query.append("@[mnr_prnr_eml] AS SENDER," ).append("\n"); 
		query.append("A.MNR_PRNR_LGL_ENG_NM AS RECIPIENT_NM," ).append("\n"); 
		query.append("@[apro_ofc_cd] AS SENDER_OFC_CD," ).append("\n"); 
		query.append("(SELECT USR_NM FROM COM_USER WHERE USR_ID = @[apro_usr_id]) AS SENDER_NM," ).append("\n"); 
		query.append("(SELECT OFC_ENG_NM FROM MDM_ORGANIZATION WHERE OFC_CD = @[apro_ofc_cd]) AS SENDER_OFC_NM" ).append("\n"); 
		query.append("FROM MNR_PARTNER A" ).append("\n"); 
		query.append("WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN (SELECT MNR_PRNR_CNT_CD," ).append("\n"); 
		query.append("MNR_PRNR_SEQ" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_PART" ).append("\n"); 
		query.append("WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND MNR_PRNR_EML = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("AND A.MNR_PRNR_EML IS NOT NULL" ).append("\n"); 

	}
}