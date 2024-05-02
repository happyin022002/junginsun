/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOModifyMGSByMNRSoldCancelDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.01.17 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOModifyMGSByMNRSoldCancelDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * --------------------------------------------------------
	  * * History
	  * * 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
	  * *                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOModifyMGSByMNRSoldCancelDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOModifyMGSByMNRSoldCancelDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_EQUIPMENT" ).append("\n"); 
		query.append("   SET (ACIAC_DIV_CD," ).append("\n"); 
		query.append("        EQ_STS_SEQ," ).append("\n"); 
		query.append("        CRNT_YD_CD," ).append("\n"); 
		query.append("        CRNT_LOC_CD," ).append("\n"); 
		query.append("        CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT)" ).append("\n"); 
		query.append("     = (SELECT /*+ INDEX_DESC (CGM_EQ_STS_HIS XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("               DECODE(EQ_ASET_STS_CD, 'LSO', 'I', 'SLD', 'I','LST', 'I','DIO', 'I','SBO', 'I','SCR', 'I','TLL', 'I', 'A') AS ACIAC_DIV_CD," ).append("\n"); 
		query.append("               EQ_STS_SEQ," ).append("\n"); 
		query.append("               STS_EVNT_YD_CD," ).append("\n"); 
		query.append("               STS_EVNT_LOC_CD," ).append("\n"); 
		query.append("               'MT'," ).append("\n"); 
		query.append("               @[flag_user_id]," ).append("\n"); 
		query.append("               SYSDATE" ).append("\n"); 
		query.append("          FROM CGM_EQ_STS_HIS" ).append("\n"); 
		query.append("         WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("           AND ROWNUM = 1)" ).append("\n"); 
		query.append(" WHERE EQ_NO = @[eq_no]" ).append("\n"); 

	}
}