/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * searchOfcComboCodeListData
	  * 2014-03-31 by Jonghee HAN 선반영 CSR Ticket : CHM-201429703, Title : ALPS MNR-Disposal Request 시, Office Code 변경에 따른 Approval Office 변경 요청, 부산지역 조직통합으로 Disposal Request시 Approval Office 선택을 위한 PUSSC Office Code 추가
	  * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT   A.OFC_CD AS CD_ID" ).append("\n"); 
		query.append("       , A.OFC_CD AS CD_DESC" ).append("\n"); 
		query.append("FROM     MNR_OFC_GEN_INFO A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.UPPR_OFC_CD  = @[searchkey]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${searchcon} == 'DISP')" ).append("\n"); 
		query.append("AND      A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND      A.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("AND      A.COST_CD       = 'RPROFC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${searchcon} == 'DISP')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   CASE WHEN @[searchkey] IN ('PUSBO','PUSSC','TYOSC','OSASO') THEN ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ) ELSE @[searchkey] END AS CD_ID" ).append("\n"); 
		query.append("       , CASE WHEN @[searchkey] IN ('PUSBO','PUSSC','TYOSC','OSASO') THEN ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' ) ELSE @[searchkey] END AS CD_DESC " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   @[searchkey] AS CD_ID" ).append("\n"); 
		query.append("       , @[searchkey] AS CD_DESC" ).append("\n"); 
		query.append("FROM     DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}