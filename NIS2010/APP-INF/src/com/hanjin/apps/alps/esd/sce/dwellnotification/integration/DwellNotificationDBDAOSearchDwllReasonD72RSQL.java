/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwllReasonD72RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwllReasonD72RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reason D72 조회
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwllReasonD72RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_rsn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwll_tm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwllReasonD72RSQL").append("\n"); 
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
		query.append("CASE WHEN DWLL_RSN_TP_CD='A' THEN 'Available for Pick up'||CHR(10)" ).append("\n"); 
		query.append("WHEN INSTR_RMK IS NULL AND NVL(DWLL_RSN_TP_CD,'N') <> 'D' THEN ''" ).append("\n"); 
		query.append("ELSE 'Cntr Delay Reason : '||DECODE(DWLL_RSN_TP_CD,'D','Demurrage Pending')||NVL2(INSTR_RMK,', '||INSTR_RMK,'') END AS DWLL_RSN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(INS XPKBKG_USA_CUST_SVC_INSTR) */ INSTR_RMK FROM BKG_USA_CUST_SVC_INSTR I WHERE H.BKG_NO = I.BKG_NO AND I.DELT_FLG = 'N' AND INSTR_RMK_TP_CD='72D' AND ROWNUM=1) INSTR_RMK" ).append("\n"); 
		query.append(",@[dwll_rsn_tp_cd] DWLL_RSN_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_DWLL_NTFC_CNDDT H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.EML_SND_DT=@[eml_snd_dt]" ).append("\n"); 
		query.append("AND H.DWLL_TM_TP_CD=@[dwll_tm_tp_cd]" ).append("\n"); 
		query.append("AND H.CNTR_NO=@[cntr_no]" ).append("\n"); 
		query.append("AND H.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append(") Z" ).append("\n"); 

	}
}