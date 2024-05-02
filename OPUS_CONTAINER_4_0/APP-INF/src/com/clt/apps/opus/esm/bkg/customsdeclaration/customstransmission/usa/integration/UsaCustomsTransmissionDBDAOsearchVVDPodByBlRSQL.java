/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchVVDPodByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.05 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchVVDPodByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchVVDPodByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchVVDPodByBlRSQL").append("\n"); 
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
		query.append("VSL_CD || SKD_VOY_NO || SKD_DIR_CD in_vvd" ).append("\n"); 
		query.append(",POD_CD in_pod" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNT_CD = 'US'" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("BL_NO = @[in_bl]" ).append("\n"); 

	}
}