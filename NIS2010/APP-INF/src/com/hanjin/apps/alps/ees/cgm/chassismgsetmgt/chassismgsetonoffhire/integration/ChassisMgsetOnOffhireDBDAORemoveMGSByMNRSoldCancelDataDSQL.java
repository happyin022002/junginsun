/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAORemoveMGSByMNRSoldCancelDataDSQL.java
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

public class ChassisMgsetOnOffhireDBDAORemoveMGSByMNRSoldCancelDataDSQL implements ISQLTemplate{

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
	public ChassisMgsetOnOffhireDBDAORemoveMGSByMNRSoldCancelDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAORemoveMGSByMNRSoldCancelDataDSQL").append("\n"); 
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
		query.append("DELETE FROM CGM_EQ_STS_HIS" ).append("\n"); 
		query.append(" WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("   AND EQ_ASET_STS_CD = @[flag_type]" ).append("\n"); 
		query.append("   AND EQ_STS_SEQ = (SELECT EQ_STS_SEQ" ).append("\n"); 
		query.append("                       FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("                      WHERE EQ_NO = @[eq_no])" ).append("\n"); 

	}
}